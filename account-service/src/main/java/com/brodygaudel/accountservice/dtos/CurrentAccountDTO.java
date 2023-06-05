package com.brodygaudel.accountservice.dtos;

import com.brodygaudel.accountservice.enums.AccountStatus;

import java.math.BigDecimal;
import java.util.Date;

public class CurrentAccountDTO extends BankAccountDTO  {
    private String id;
    private BigDecimal balance;
    private Date createdAt;
    private AccountStatus status;
    private Long customerId;
    private double overDraft;

    public CurrentAccountDTO(String id, BigDecimal balance, Date createdAt, AccountStatus status, Long customerId, double overDraft) {
        this.id = id;
        this.balance = balance;
        this.createdAt = createdAt;
        this.status = status;
        this.customerId = customerId;
        this.overDraft = overDraft;
    }

    public CurrentAccountDTO() {
        super();
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

    public double getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }
}
