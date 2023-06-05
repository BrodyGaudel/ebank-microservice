package com.brodygaudel.accountservice.dtos;

import com.brodygaudel.accountservice.enums.AccountStatus;

import java.math.BigDecimal;

public record UpdateCurrentAccountDTO(String id, BigDecimal balance, double overDraft, AccountStatus status) { }
