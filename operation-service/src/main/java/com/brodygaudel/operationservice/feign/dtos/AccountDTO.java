package com.brodygaudel.operationservice.feign.dtos;

import com.brodygaudel.operationservice.enums.AccountStatus;

import java.math.BigDecimal;
import java.util.Date;

public record AccountDTO(String id, BigDecimal balance, Date createdAt, AccountStatus status,
                         Long customerId, double overDraft, double interestRate) { }
