package com.brodygaudel.accountservice.dtos;

import java.math.BigDecimal;

public record SaveSavingAccountDTO(BigDecimal initialBalance, double interestRate, Long customerId) { }
