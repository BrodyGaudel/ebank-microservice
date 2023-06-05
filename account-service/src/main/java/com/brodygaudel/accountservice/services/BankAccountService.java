package com.brodygaudel.accountservice.services;

import com.brodygaudel.accountservice.dtos.*;
import com.brodygaudel.accountservice.exceptions.BankAccountNotFoundException;
import com.brodygaudel.accountservice.exceptions.CommandRejectedException;
import com.brodygaudel.accountservice.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    List<BankAccountDTO> getAllBankAccount();
    BankAccountDTO getBankAccountById(String id) throws BankAccountNotFoundException;
    CurrentAccountDTO saveCurrentBankAccount(SaveCurrentAccountDTO savedAccountDTO) throws CustomerNotFoundException;
    SavingAccountDTO saveSavingAccount(SaveSavingAccountDTO savingAccountDTO) throws CustomerNotFoundException;
    CurrentAccountDTO updateCurrentAccount(UpdateCurrentAccountDTO accountDTO) throws BankAccountNotFoundException, CommandRejectedException;
    SavingAccountDTO updateSavingAccount(UpdateSavingAccountDTO accountDTO) throws BankAccountNotFoundException, CommandRejectedException;
    AccountDTO getAccountById(String id) throws BankAccountNotFoundException;
}
