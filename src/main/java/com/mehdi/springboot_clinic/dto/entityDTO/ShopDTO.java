package com.mehdi.springboot_clinic.dto.entityDTO;

import lombok.Data;

@Data
public class ShopDTO {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String country;
    private Long managerId;
}
