package com.mehdi.springboot_clinic.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mehdi.springboot_clinic.dto.entityDTO.AdminDTO;
import com.mehdi.springboot_clinic.dto.saveDTO.AdminSaveDTO;
import com.mehdi.springboot_clinic.entity.Admin;
import com.mehdi.springboot_clinic.entity.Role;
import com.mehdi.springboot_clinic.entity.User;
import com.mehdi.springboot_clinic.repository.AdminRepository;
import com.mehdi.springboot_clinic.repository.RoleRepository;
import com.mehdi.springboot_clinic.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ObjectMapper objectMapper;


    @Autowired
    public AdminService(AdminRepository adminRepository, ModelMapper modelMapper,
                        UserRepository userRepository, RoleRepository roleRepository, ObjectMapper objectMapper) {
        this.adminRepository = adminRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.objectMapper = objectMapper;

        // Configure mapping for Admin to AdminDTO
        modelMapper.addMappings(new PropertyMap<Admin, AdminDTO>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
            }
        });
    }


    public AdminDTO create(String jsonString) throws JsonProcessingException {
        AdminSaveDTO adminSaveDTO = objectMapper.readValue(jsonString, AdminSaveDTO.class);

        Admin admin = modelMapper.map(adminSaveDTO, Admin.class);
        admin.setPassword(passwordEncoder.encode(adminSaveDTO.getPassword()));
        Role adminRole = roleRepository.findRoleByName("ROLE_ADMIN");
        if (adminRole == null) {
            // سجّل خطأ أو قم بطباعة رسالة إلى وحدة التحكم
            System.out.println("Role not found: ROLE_ADMIN");
        }
        admin.setRole(adminRole);
        Admin newAdmin = adminRepository.save(admin);

        User user = new User();
        user.setFirstName(adminSaveDTO.getFirstName());
        user.setLastName(adminSaveDTO.getLastName());
        user.setEmail(adminSaveDTO.getEmail());
        user.setPassword(passwordEncoder.encode(adminSaveDTO.getPassword()));
        List<Role> roles = new ArrayList<>();
        roles.add(adminRole);
        user.setRoles(roles);
        user.setSecondId(admin.getId());
        userRepository.save(user);

        return modelMapper.map(newAdmin, AdminDTO.class);
    }
}
