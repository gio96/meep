package org.meep.gateway;

import org.meep.entities.Vehicle;
import reactor.core.publisher.Flux;

public interface VehicleGateway {
    Flux<Vehicle> getVehicles(String userAgent);
}
