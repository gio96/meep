package org.meep.entities;

import lombok.*;

import java.util.List;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

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
