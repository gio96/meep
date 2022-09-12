package org.meep.usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.meep.entities.Vehicle;
import org.meep.gateway.VehicleGateway;
import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
public class VehiclesUseCase {

    private final static String USERAGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36";

    private final VehicleGateway vehicleGateway;
    private final ObjectMapper objectMapper;


    public Flux<ServerSentEvent<String>> getVehicles() {
        //return Flux.interval(Duration.ofSeconds(30))
        return Flux.interval(Duration.ofSeconds(5))
                .flatMap(aLong -> convertVehicleToJson(vehicleGateway.getVehicles(USERAGENT)))
                .map(json -> ServerSentEvent.<String>builder()
                        .id(UUID.randomUUID().toString())
                        .event("message-event")
                        .data(json)
                        .build());
    }

    private Mono<String> convertVehicleToJson(Flux<Vehicle> vehiclesFlux) {
        return vehiclesFlux
                .collectList()
                .map(vehicles -> vehicles.stream()
                        .map(vehicles1 -> {
                            try {
                                return objectMapper.writeValueAsString(vehicles1);
                            } catch (JsonProcessingException e) {
                                log.error(e.getMessage());
                            }
                            return null;
                        })).
                        map(stringStream -> stringStream
                                .collect(Collectors.joining(",", "[", "]")));
    }
}
