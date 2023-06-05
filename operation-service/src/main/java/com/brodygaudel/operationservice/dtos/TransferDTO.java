package com.brodygaudel.operationservice.dtos;

import java.math.BigDecimal;

public record TransferDTO(String accountSource, String accountDestination, BigDecimal amount, String description) { }
