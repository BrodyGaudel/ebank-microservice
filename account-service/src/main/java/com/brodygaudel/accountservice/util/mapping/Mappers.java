package com.brodygaudel.accountservice.util.mapping;

import com.brodygaudel.accountservice.dtos.BankAccountDTO;
import com.brodygaudel.accountservice.dtos.CurrentAccountDTO;
import com.brodygaudel.accountservice.dtos.SavingAccountDTO;
import com.brodygaudel.accountservice.entities.BankAccount;
import com.brodygaudel.accountservice.entities.CurrentAccount;
import com.brodygaudel.accountservice.entities.SavingAccount;

import java.util.List;

public interface Mappers {
    SavingAccountDTO fromSavingAccount(SavingAccount savingAccount);
    SavingAccount fromSavingAccountDTO(SavingAccountDTO savingBankAccountDTO);
    CurrentAccountDTO fromCurrentAccount(CurrentAccount currentAccount);
    CurrentAccount fromCurrentAccountDTO(CurrentAccountDTO currentBankAccountDTO);
    BankAccountDTO fromBankAccount(BankAccount bankAccount);
    List<BankAccountDTO> fromListOfBankAccount(List<BankAccount> bankAccounts);
}
