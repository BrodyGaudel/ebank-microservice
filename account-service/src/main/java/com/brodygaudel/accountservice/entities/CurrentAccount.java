package com.brodygaudel.accountservice.entities;

import com.brodygaudel.accountservice.enums.AccountStatus;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@DiscriminatorValue("CA")
public class CurrentAccount extends BankAccount {

    private double overDraft;

    public CurrentAccount(String id, BigDecimal balance, Date createdAt, AccountStatus status, Long customerId, double overDraft) {
        super(id, balance, createdAt, status, customerId);
        this.overDraft = overDraft;
    }

    public CurrentAccount() {
    }

    public double getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }
}
