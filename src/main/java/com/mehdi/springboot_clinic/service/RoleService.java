package com.mehdi.springboot_clinic.service;

import com.mehdi.springboot_clinic.dto.entityDTO.RoleDTO;
import com.mehdi.springboot_clinic.entity.Role;
import com.mehdi.springboot_clinic.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public RoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    public RoleDTO create(String roleName){
        Role role = new Role();
        roleName = "Role_" + roleName.toUpperCase();
        role.setName(roleName);
        return modelMapper.map(role,RoleDTO.class);
    }
}
