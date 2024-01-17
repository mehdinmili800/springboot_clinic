package com.mehdi.springboot_clinic.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mehdi.springboot_clinic.dto.entityDTO.ClientDTO;
import com.mehdi.springboot_clinic.dto.entityDTO.UserDTO;
import com.mehdi.springboot_clinic.dto.saveDTO.ClientSaveDTO;
import com.mehdi.springboot_clinic.entity.Client;
import com.mehdi.springboot_clinic.entity.Role;
import com.mehdi.springboot_clinic.entity.User;
import com.mehdi.springboot_clinic.repository.ClientRepository;
import com.mehdi.springboot_clinic.repository.RoleRepository;
import com.mehdi.springboot_clinic.repository.UserRepository;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;


    @Autowired
    public ClientService(ClientRepository clientRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder,
                         RoleRepository roleRepository,
                         UserRepository userRepository, ObjectMapper objectMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;

        modelMapper.addMappings(new PropertyMap<Client, ClientDTO>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
            }
        });
    }

    public ClientDTO create(String jsonString) throws JsonProcessingException {
        ClientSaveDTO clientSaveDTO = objectMapper.readValue(jsonString, ClientSaveDTO.class);

        //convert DTO to entity
        Client client = modelMapper.map(clientSaveDTO, Client.class);
        client.setPassword(passwordEncoder.encode(clientSaveDTO.getPassword()));
        Role clientRole = roleRepository.findRoleByName("ROLE_CLIENT");
        client.setRole(clientRole);
        client.setEnabled(true);
        Client newClient = clientRepository.save(client);

        User user = new User();
        user.setFirstName(clientSaveDTO.getFirstName());
        user.setLastName(clientSaveDTO.getLastName());
        user.setEmail((clientSaveDTO.getEmail()));
        user.setPassword(passwordEncoder.encode(clientSaveDTO.getPassword()));
        user.setEnabled(true);
        List<Role> roles = new ArrayList<>();
        roles.add(clientRole);
        user.setRoles(roles);
        userRepository.save(user);

        //convert entity to DTO
        return modelMapper.map(newClient, ClientDTO.class);
    }

}
