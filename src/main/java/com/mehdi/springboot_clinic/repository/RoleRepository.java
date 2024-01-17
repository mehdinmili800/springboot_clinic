package com.mehdi.springboot_clinic.repository;

import com.mehdi.springboot_clinic.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findRoleByName(String name);
}
