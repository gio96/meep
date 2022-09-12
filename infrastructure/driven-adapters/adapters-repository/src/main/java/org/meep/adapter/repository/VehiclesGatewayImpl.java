package org.meep.adapter.repository;

import lombok.AllArgsConstructor;
import org.meep.entities.Vehicle;
//import org.meep.feign.MeepApi;
//import org.meep.feign.dto.VehicleDto;
import org.meep.gateway.VehicleGateway;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@AllArgsConstructor
public class VehiclesGatewayImpl implements VehicleGateway {

    //private final MeepApi meepApi;

    @Override
    public Flux<Vehicle> getVehicles(String userAgent) {
        //return meepApi.getVehicles(userAgent).map(this::vehicleDtoToVehicle);
        return Flux.just(Vehicle.builder().build());
    }

    /*private Vehicle vehicleDtoToVehicle(VehicleDto vehicleDto){
        return Vehicle.builder()
                .id(vehicleDto.getId())
                .name(vehicleDto.getName())
                .x(vehicleDto.getX())
                .y(vehicleDto.getY())
                .licencePlate(vehicleDto.getLicencePlate())
                .range(vehicleDto.getRange())
                .batteryLevel(vehicleDto.getBatteryLevel())
                .helmets(vehicleDto.getHelmets())
                .model(vehicleDto.getModel())
                .resourceImageId(vehicleDto.getResourceImageId())
                .resourcesImagesUrls(vehicleDto.getResourcesImagesUrls())
                .realTimeData(vehicleDto.getRealTimeData())
                .resourceType(vehicleDto.getResourceType())
                .companyZoneId(vehicleDto.getCompanyZoneId())
                .build();
    }*/
}
