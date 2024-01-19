package com.mehdi.springboot_clinic.dto.entityDTO;


import com.mehdi.springboot_clinic.entity.Client;
import com.mehdi.springboot_clinic.entity.Doctor;
import com.mehdi.springboot_clinic.entity.Shop;
import lombok.Data;

@Data
public class FeedbackDTO {

    private Long id;
    private Client client;
    private Shop shop;
    private Doctor doctor;
    private String title;
    private String message;

}
