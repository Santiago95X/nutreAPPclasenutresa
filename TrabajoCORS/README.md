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
- `src/main/java/com/example/NutreAPP/configurations/CorsConfig.java` — el código de la clase.

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
