package com.mehdi.springboot_clinic.repository;

import com.mehdi.springboot_clinic.entity.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, Long>, JpaSpecificationExecutor<Receptionist> {
    List<Receptionist> findAllByEnabled(Boolean enabled);

    Receptionist findByEmail(String loggedInEmail);
}
