package com.brodygaudel.operationservice.feign.dtos;

import com.brodygaudel.operationservice.enums.AccountStatus;

import java.math.BigDecimal;

public record UpdateCurrentAccountDTO(String id, BigDecimal balance, double overDraft, AccountStatus status) { }
