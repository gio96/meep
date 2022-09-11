package org.meep;

import lombok.RequiredArgsConstructor;
import org.meep.entities.Vehicle;
import org.meep.usecase.VehiclesUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class VehiclesController {

    private final VehiclesUseCase vehiclesUseCase;

    @GetMapping(value = "/vehicles")
    public Flux<Vehicle> getVehicles() {
        return vehiclesUseCase.getVehicles();
    }
}
