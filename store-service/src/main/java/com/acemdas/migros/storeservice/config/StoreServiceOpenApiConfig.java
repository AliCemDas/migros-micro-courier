package com.acemdas.migros.storeservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreServiceOpenApiConfig {
    @Bean
    public OpenAPI storeServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Migros Store Service API")
                        .description("Contains Migros Store Micro-service Documentation")
                        .version("v1.0"));
    }
}
