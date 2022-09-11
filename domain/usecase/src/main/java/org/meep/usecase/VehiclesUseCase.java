package org.meep.usecase;

import lombok.RequiredArgsConstructor;
import org.meep.entities.Vehicle;
import org.meep.gateway.VehicleGateway;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class VehiclesUseCase {

    private final VehicleGateway vehicleGateway;
    private final static String USERAGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36";

    public Flux<Vehicle> getVehicles() {
        return vehicleGateway.getVehicles(USERAGENT);
    }
}
