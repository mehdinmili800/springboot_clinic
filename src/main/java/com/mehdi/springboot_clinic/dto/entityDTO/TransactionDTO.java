package com.mehdi.springboot_clinic.dto.entityDTO;


import com.mehdi.springboot_clinic.entity.Bill;
import com.mehdi.springboot_clinic.entity.Client;
import com.mehdi.springboot_clinic.entity.Pet;
import com.mehdi.springboot_clinic.entity.User;
import lombok.Data;

@Data
public class TransactionDTO {
    private Long id;
    private Bill bill;
    private Client client;
    private User user;
    private Long productId;
    private String productName;
    private double pricePerUnit;
    private double quantity;
    private double total;
    private Pet pet;
    private boolean isPaid;
}
