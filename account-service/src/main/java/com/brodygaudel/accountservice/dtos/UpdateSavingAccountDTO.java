package com.brodygaudel.accountservice.dtos;

import com.brodygaudel.accountservice.enums.AccountStatus;

import java.math.BigDecimal;

public record UpdateSavingAccountDTO(String id, BigDecimal balance, double interestRate, AccountStatus status) { }
