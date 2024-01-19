package com.mehdi.springboot_clinic.dto.saveDTO;

import lombok.Data;

@Data
public class TransactionSaveDTO {
    private Long clientId;
    private Long productId;
    private Long petId;
    private double quantity;
}
