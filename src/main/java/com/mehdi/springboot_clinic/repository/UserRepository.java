package com.mehdi.springboot_clinic.repository;

import com.mehdi.springboot_clinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    Optional<User> findUserByEmail(String email);

    User findByEmail(String email);

    List<User> findAllByEnabled(Boolean enabled);

    Optional<User> findUserById(long id);
}

