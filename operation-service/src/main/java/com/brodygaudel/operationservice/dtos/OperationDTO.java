package com.brodygaudel.operationservice.dtos;

import com.brodygaudel.operationservice.enums.OperationType;

import java.math.BigDecimal;
import java.util.Date;

public record OperationDTO(Long id, Date date, BigDecimal amount, OperationType type, String description) { }
