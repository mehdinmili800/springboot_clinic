package com.mehdi.springboot_clinic.dto.entityDTO;

import com.mehdi.springboot_clinic.entity.Role;
import lombok.Data;

@Data
public class AdminDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;

}

