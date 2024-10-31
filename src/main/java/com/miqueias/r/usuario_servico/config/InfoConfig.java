package com.miqueias.r.usuario_servico.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class InfoConfig {

    @Value("${spring.application.name}")
    private String nome;


    @Value("${info}")
    private String ambiente;

    @Bean
    public InfoContributor appInfoContributor() {
        return builder -> builder.withDetail("app", Map.of(
                "name", nome,
                "version", "1.0.0",
                "author", "Miqueias Rodrigues",
                "ambiente", ambiente
        ));
    }
}
