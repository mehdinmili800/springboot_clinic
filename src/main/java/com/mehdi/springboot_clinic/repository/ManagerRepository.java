package com.mehdi.springboot_clinic.repository;

import com.mehdi.springboot_clinic.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long>, JpaSpecificationExecutor<Manager> {
    Manager findByEmail(String loggedInEmail);

    List<Manager> findAllByEnabled(Boolean enabled);
}
