package org.meep.feign;

import org.meep.feign.dto.VehicleDto;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;

@ReactiveFeignClient(value = "meep-service", url = "${meep.service.url}")
@Component
public interface MeepApi {

    @GetMapping("")
    Flux<VehicleDto> getVehicles(@RequestHeader("user-agent") String userAgent);

}
