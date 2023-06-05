package com.brodygaudel.accountservice.dtos;

import java.math.BigDecimal;

public record SaveCurrentAccountDTO(BigDecimal initialBalance, double overDraft, Long customerId) { }
