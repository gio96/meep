package org.meep.config;

import org.meep.gateway.VehicleGateway;
import org.meep.usecase.VehiclesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public VehiclesUseCase vehiclesUseCase(VehicleGateway vehicleGateway){
        return new VehiclesUseCase(vehicleGateway);
    }
}
