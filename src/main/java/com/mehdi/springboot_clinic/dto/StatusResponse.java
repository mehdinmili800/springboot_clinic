package com.mehdi.springboot_clinic.dto;

import com.mehdi.springboot_clinic.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StatusResponse {
    private String sessionId;
    private int status;
    private Long userId;
    private String message;
    private List<Role> roles;
    private Role role;
}
