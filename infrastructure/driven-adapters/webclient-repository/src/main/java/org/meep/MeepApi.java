package org.meep;

import lombok.RequiredArgsConstructor;
import org.meep.dto.VehicleDto;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class MeepApi {

    private final WebClient webClient;

    String url = "https://apidev.meep.me/tripplan/api/v1/routers/lisboa/resources?lowerLeftLatLon=38.711046,-9.160096&upperRightLatLon=38.739429,-9.137115&companyZoneIds=545,467,473";

    public Flux<VehicleDto> someRestCall(String name) {
        return this.webClient.get().uri(url).header("user-agent",name)
                .retrieve().bodyToFlux(VehicleDto.class);
    }
}
