package com.example.graphqlserver.service.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class MapperConfiguration {
    @Bean
    public RestTemplate objectMapper() {
        return new RestTemplate();
    }
}
