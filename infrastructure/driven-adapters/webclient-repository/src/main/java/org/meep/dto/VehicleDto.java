package org.meep.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {

    private String id;
    private String name;
    private Double x;
    private Double y;
    private String licencePlate;
    private Integer range;
    private Integer batteryLevel;
    private Integer helmets;
    private String model;
    private String resourceImageId;
    private List<String> resourcesImagesUrls;
    private Boolean realTimeData;
    private String resourceType;
    private Integer companyZoneId;
}
