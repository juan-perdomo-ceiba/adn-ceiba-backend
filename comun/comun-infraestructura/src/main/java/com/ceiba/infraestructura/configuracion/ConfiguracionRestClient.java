package com.ceiba.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfiguracionRestClient {

    @Bean
    public RestTemplate clienteRest() {
        return new RestTemplate();
    }
}
