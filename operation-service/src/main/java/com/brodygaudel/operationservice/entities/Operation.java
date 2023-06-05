package com.brodygaudel.operationservice.entities;

import com.brodygaudel.operationservice.enums.OperationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private OperationType type;
    private String description;
    @Column(nullable = false)
    private String bankAccountId;
}
