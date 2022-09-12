package org.meep.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.meep.gateway.VehicleGateway;
import org.meep.usecase.VehiclesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class UseCaseConfig {

    @Bean
    public VehiclesUseCase vehiclesUseCase(VehicleGateway vehicleGateway,ObjectMapper objectMapper){
        return new VehiclesUseCase(vehicleGateway, objectMapper);
    }

    @Bean
    WebClient.Builder builder() {
        return WebClient.builder();
    }

    @Bean
    WebClient webClient(WebClient.Builder b) {
        return b.build();
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);

        return mapper;
    }
}
