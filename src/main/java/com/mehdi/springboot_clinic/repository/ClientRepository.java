package com.mehdi.springboot_clinic.repository;

import com.mehdi.springboot_clinic.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long>, JpaSpecificationExecutor<Client> {

    Client findByEmail(String email);

    Optional<Client> findClientById(long id);

    Client findById(long id);

    List<Client> findAllByEnabled(boolean enabled);
}
