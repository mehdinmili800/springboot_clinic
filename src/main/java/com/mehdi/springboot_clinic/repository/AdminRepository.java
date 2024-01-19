package com.mehdi.springboot_clinic.repository;

import com.mehdi.springboot_clinic.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>, JpaSpecificationExecutor<Admin> {

    @Query("select a from Admin a where a.enabled=true")
    List<Admin> findEnabledAdmins();

    Optional<Admin> findAdminById(Long id);

    Admin findAdminByEmail(String email);
}