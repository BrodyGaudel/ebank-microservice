package com.brodygaudel.operationservice.services;

import com.brodygaudel.operationservice.dtos.*;
import com.brodygaudel.operationservice.exceptions.BalanceNotSufficientException;
import com.brodygaudel.operationservice.exceptions.BankAccountNotFoundException;
import com.brodygaudel.operationservice.exceptions.OperationNotFoundException;

import java.util.List;

public interface OperationService {
    DebitDTO debit(DebitDTO debitDTO) throws BankAccountNotFoundException, BalanceNotSufficientException;

    CreditDTO credit(CreditDTO creditDTO) throws BankAccountNotFoundException;

    TransferDTO transfer(TransferDTO transferDTO) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<OperationDTO> getAllOperationsByAccountId(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    OperationDTO getOperationById(Long id) throws OperationNotFoundException;
}
