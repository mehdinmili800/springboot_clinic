package com.mehdi.springboot_clinic.repository;

import com.mehdi.springboot_clinic.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessionRepository extends JpaRepository<Session, UUID> {
    Session findSessionBySessionId(String sid);
}
