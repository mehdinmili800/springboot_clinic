package com.mehdi.springboot_clinic.repository;

import com.mehdi.springboot_clinic.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>, JpaSpecificationExecutor<Shop> {

    List<Shop> findAllByEnabled(Boolean enabled);
}