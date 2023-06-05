package com.brodygaudel.operationservice.feign.dtos;

import com.brodygaudel.operationservice.enums.AccountStatus;

import java.math.BigDecimal;

public record UpdateSavingAccountDTO(String id, BigDecimal balance, double interestRate, AccountStatus status) { }
