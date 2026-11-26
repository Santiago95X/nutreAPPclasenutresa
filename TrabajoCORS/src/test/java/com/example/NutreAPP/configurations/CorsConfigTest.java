package com.example.NutreAPP.configurations;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Comprueba que CorsConfig responde con las cabeceras CORS esperadas
@WebMvcTest(controllers = CorsConfigTest.PruebaControlador.class)
@Import({CorsConfig.class, CorsConfigTest.PruebaControlador.class})
class CorsConfigTest {

    private static final String ORIGEN = "http://localhost:5500";

    @RestController
    static class PruebaControlador {
        @GetMapping("/prueba")
        String prueba() {
            return "ok";
        }
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    void preflightDevuelveLasCabecerasCors() throws Exception {
        mockMvc.perform(options("/prueba")
                        .header("Origin", ORIGEN)
                        .header("Access-Control-Request-Method", "DELETE")
                        .header("Access-Control-Request-Headers", "Authorization"))
                .andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin", ORIGEN))
                .andExpect(header().string("Access-Control-Allow-Credentials", "true"))
                .andExpect(header().string("Access-Control-Max-Age", "3600"));
    }

    @Test
    void peticionNormalDevuelveElOrigen() throws Exception {
        mockMvc.perform(get("/prueba").header("Origin", ORIGEN))
                .andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin", ORIGEN));
    }
}
