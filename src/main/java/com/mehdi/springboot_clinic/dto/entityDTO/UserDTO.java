package com.mehdi.springboot_clinic.dto.entityDTO;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String about;
    private Long userId;
}
