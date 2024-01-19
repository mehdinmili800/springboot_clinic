package com.mehdi.springboot_clinic.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String email;
    private String password;
    private Long roleId;
}
