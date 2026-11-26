# TrabajoCORS

Espacio de trabajo aparte de `NutreAPP` para la configuración de CORS vista en clase.
Es un proyecto Spring Boot independiente: compila y se prueba por sí solo.

## Punto de partida

- `fotos/` — fotos de la pantalla del profesor:
  - `01-corsconfig-profesor.jpg`: la clase `CorsConfig` completa.
  - `02-estructura-proyecto.jpg`: ubicación del archivo (`configurations/CorsConfig.java`).
  - `03-pantalla-completa.jpg`: vista general de VS Code.
  - `04-corsconfiguration-con-error.jpg`: versión con error: el método se escribió
    `addCorsMapping` (sin **s**). El correcto es `addCorsMappings`; si no, `@Override` falla.
  - `05-tablero-plan-frontend-react.jpg`: plan del frontend en React (ver abajo).
  - `06-postman-api-usuarios.jpg`: la API `/api/v1/usuarios` probada en Postman.
- `src/main/java/com/example/NutreAPP/configurations/CorsConfig.java` — el código de la clase.

## Para qué sirve el CORS en esta clase

El tablero muestra un frontend en **React** que consume la API de NutreAPP con `fetch`.
React corre en otro puerto (p. ej. `localhost:5173`) y la API en `localhost:8080`:
son orígenes distintos, así que sin `CorsConfig` el navegador bloquea las peticiones.
Postman no aplica CORS; por eso allí funciona aunque el navegador falle.

### Plan del tablero (React Router DOM)

| Vista | Qué hace | Petición |
|---|---|---|
| **Home** | Página de inicio | — |
| **Registro usuario** | 1. Pintar el formulario · 2. Validar (hooks) · 3. Capturar datos · 4. Crear servicio → `fetch` | `POST localhost:8080/api/v1/usuarios` con cuerpo JSON |
| **Admin users** (vista dinámica) | 1. Consumir la API · 2. `map` para pintar las tarjetas; botones editar y borrar | `GET` (todos), `PUT` (editar), `DELETE` (borrar) |

### API que se ve en Postman

| Método | URL |
|---|---|
| GET | `/api/v1/usuarios` — todos |
| GET | `/api/v1/usuarios/{id}` — uno (id UUID) |
| POST | `/api/v1/usuarios` — crear |
| PUT | `/api/v1/usuarios/{id}` — editar |

Respuesta de ejemplo (coincide con el modelo `Usuario` de NutreAPP):

```json
[
  {
    "id": "42ae816e-3135-4b50-9d03-c90f41587730",
    "nombre": "Carlos Restrepo",
    "correo": "carlos.restrepo@nutresa.com",
    "rol": "EMPLEADO",
    "departamento": "TI",
    "contrasena_hash": "hash_prueba_123",
    "visualizaciones": []
  }
]
```

## Qué hace `CorsConfig`

Permite que un frontend publicado en otro dominio/puerto llame a la API:

| Método | Efecto |
|---|---|
| `addMapping("/**")` | Aplica a todos los endpoints |
| `allowedOriginPatterns("*")` | Cualquier origen (a diferencia de `allowedOrigins("*")`, funciona con credenciales) |
| `allowedMethods(...)` | GET, POST, PUT, PATCH, DELETE, OPTIONS, HEAD |
| `allowedHeaders("*")` | Cualquier cabecera en la petición |
| `exposedHeaders("*")` | El frontend puede leer todas las cabeceras de la respuesta |
| `allowCredentials(true)` | Permite cookies y la cabecera `Authorization` |
| `maxAge(3600)` | El navegador guarda el preflight (OPTIONS) 1 hora |

## Cómo ejecutarlo

```bash
./mvnw test             # Windows: mvnw.cmd test
./mvnw spring-boot:run
```

`CorsConfigTest` comprueba que el preflight y una petición GET devuelven las cabeceras CORS.
