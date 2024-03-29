package com.mehdi.springboot_clinic.repository;

import com.mehdi.springboot_clinic.entity.Client;
import com.mehdi.springboot_clinic.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {
    @Query("select t from Transaction t where t.client=?1 and t.isPaid=?2")
    List<Transaction> findAllByClientAndPaid(Client client, boolean isPaid);
}

