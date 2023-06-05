package com.brodygaudel.operationservice.repositories;

import com.brodygaudel.operationservice.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query("select o from Operation o where o.bankAccountId =?1")
    List<Operation> findByBankAccountId(String accountId);

    Page<Operation> findByBankAccountIdOrderByDateDesc(String accountId, Pageable pageable);
}
