package com.mehdi.springboot_clinic.dto.saveDTO;

import com.mehdi.springboot_clinic.entity.Role;
import lombok.Data;

@Data
public class ReceptionistSaveDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    private Long shopId;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String about;
}
