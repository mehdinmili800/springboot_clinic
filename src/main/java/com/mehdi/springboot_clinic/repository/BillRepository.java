package com.mehdi.springboot_clinic.repository;

import com.mehdi.springboot_clinic.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
