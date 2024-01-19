package com.mehdi.springboot_clinic.dto.entityDTO;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private double pricePerUnit;
    private double stock;
    private String type;
}
