package com.mehdi.springboot_clinic.dto.saveDTO;

import lombok.Data;

@Data
public class ProductSaveDTO {
    private String name;
    private double pricePerUnit;
    private double stock;
    private String type;
}
