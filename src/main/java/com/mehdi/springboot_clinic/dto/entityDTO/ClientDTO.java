package com.mehdi.springboot_clinic.dto.entityDTO;

import lombok.Data;

@Data
public class ClientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String occupation;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String about;
}
