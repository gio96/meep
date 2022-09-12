package org.meep;

import lombok.RequiredArgsConstructor;
import org.meep.dto.VehicleDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class MeepApi {

    private final WebClient webClient;

    @Value("${meep.service.url}")
    String url;

    public Flux<VehicleDto> getVehiclesMeep(String name) {
        return this.webClient
                .get()
                .uri(url)
                .header("user-agent", name)
                .retrieve()
                .bodyToFlux(VehicleDto.class);
    }
}
