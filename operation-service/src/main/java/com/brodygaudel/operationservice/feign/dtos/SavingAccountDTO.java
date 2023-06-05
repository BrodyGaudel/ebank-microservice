package com.brodygaudel.operationservice.feign.dtos;


import com.brodygaudel.operationservice.enums.AccountStatus;

import java.math.BigDecimal;
import java.util.Date;

public class SavingAccountDTO extends BankAccountDTO {
    private String id;
    private BigDecimal balance;
    private Date createdAt;
    private AccountStatus status;
    private Long customerId;
    private double interestRate;

    public SavingAccountDTO() {
        super();
    }

    public SavingAccountDTO(String id, BigDecimal balance, Date createdAt, AccountStatus status, Long customerId, double interestRate) {
        this.id = id;
        this.balance = balance;
        this.createdAt = createdAt;
        this.status = status;
        this.customerId = customerId;
        this.interestRate = interestRate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
