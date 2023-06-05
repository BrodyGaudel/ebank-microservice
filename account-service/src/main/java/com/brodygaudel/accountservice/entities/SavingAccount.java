package com.brodygaudel.accountservice.entities;

import com.brodygaudel.accountservice.enums.AccountStatus;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@DiscriminatorValue("SA")
public class SavingAccount extends BankAccount {

    private double interestRate;

    public SavingAccount(String id, BigDecimal balance, Date createdAt, AccountStatus status, Long customerId, double interestRate) {
        super(id, balance, createdAt, status, customerId);
        this.interestRate = interestRate;
    }

    public SavingAccount() {
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
