package com.mehdi.springboot_clinic.dto.entityDTO;

import com.mehdi.springboot_clinic.entity.Shop;
import lombok.Data;

@Data
public class DoctorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Shop shop;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String about;

}
