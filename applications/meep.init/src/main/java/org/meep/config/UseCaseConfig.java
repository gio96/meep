package org.meep.config;

import org.meep.gateway.VehicleGateway;
import org.meep.usecase.VehiclesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class UseCaseConfig {

    @Bean
    public VehiclesUseCase vehiclesUseCase(VehicleGateway vehicleGateway){
        return new VehiclesUseCase(vehicleGateway);
    }

    @Bean
    WebClient.Builder builder() {
        return WebClient.builder();
    }

    @Bean
    WebClient webClient(WebClient.Builder b) {
        return b.build();
    }
}
