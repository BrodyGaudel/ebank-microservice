package com.brodygaudel.operationservice.services.impl;

import com.brodygaudel.operationservice.dtos.*;
import com.brodygaudel.operationservice.entities.Operation;
import com.brodygaudel.operationservice.enums.OperationType;
import com.brodygaudel.operationservice.exceptions.BalanceNotSufficientException;
import com.brodygaudel.operationservice.exceptions.OperationNotFoundException;
import com.brodygaudel.operationservice.feign.AccountFeignClient;
import com.brodygaudel.operationservice.feign.dtos.*;
import com.brodygaudel.operationservice.repositories.OperationRepository;
import com.brodygaudel.operationservice.services.OperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;
    private final AccountFeignClient accountFeignClient;

    public OperationServiceImpl(OperationRepository operationRepository, AccountFeignClient accountFeignClient) {
        this.operationRepository = operationRepository;
        this.accountFeignClient = accountFeignClient;
    }

    @Override
    public DebitDTO debit(DebitDTO debitDTO) throws BalanceNotSufficientException {
        AccountDTO account = accountFeignClient.findById(debitDTO.accountId());
        if(account.interestRate() == -1){
            if(debitDTO.amount().compareTo(account.balance()) > 0) {
                throw new BalanceNotSufficientException("Balance not sufficient");
            }
            BigDecimal balance = account.balance().subtract(debitDTO.amount());
            CurrentAccountDTO accountDTO = accountFeignClient.updateCurrentAccount(new UpdateCurrentAccountDTO(
                    account.id(), balance, account.overDraft(), account.status()));
            return saveDebitDTO(debitDTO, account, accountDTO.getId());
        }else{
            BigDecimal balance = account.balance().subtract(debitDTO.amount());
            SavingAccountDTO accountDTO = accountFeignClient.updateSavingAccount(new UpdateSavingAccountDTO(account.id(), balance,
                    account.interestRate(), account.status()));
            return saveDebitDTO(debitDTO, account, accountDTO.getId());
        }
    }

    @Override
    public CreditDTO credit(CreditDTO creditDTO){
        AccountDTO account = accountFeignClient.findById(creditDTO.accountId());
        if(account.interestRate() == -1){
            CurrentAccountDTO accountDTO = accountFeignClient
                    .updateCurrentAccount(new UpdateCurrentAccountDTO(account.id(),
                            account.balance().add(creditDTO.amount()), account.overDraft(), account.status()));
            return saveCreditDTO(creditDTO, account, accountDTO.getId());
        }else{
            SavingAccountDTO accountDTO = accountFeignClient.updateSavingAccount(new UpdateSavingAccountDTO(account.id(),
                    account.balance().add(creditDTO.amount()), account.interestRate(), account.status()));
            return saveCreditDTO(creditDTO, account, accountDTO.getId());
        }
    }

    @Override
    public TransferDTO transfer(TransferDTO transferDTO) throws BalanceNotSufficientException {
        DebitDTO debitDTO = new DebitDTO(transferDTO.accountSource(), transferDTO.amount(), transferDTO.description());
        DebitDTO debitDTOSaved = debit(debitDTO);
        CreditDTO creditDTO = new CreditDTO(transferDTO.accountDestination(), transferDTO.amount(), transferDTO.description());
        CreditDTO creditDTOSaved = credit(creditDTO);
        log.info("transfer successfully");
        return new TransferDTO(debitDTOSaved.accountId(), creditDTOSaved.accountId(), creditDTOSaved.amount(), debitDTOSaved.description());
    }

    @Override
    public List<OperationDTO> getAllOperationsByAccountId(String accountId) {
        List<Operation> operations = operationRepository.findByBankAccountId(accountId);
        log.info("operations found");
        return operations.stream().map(this::fromOperation).toList();
    }

    @Override
    public AccountHistoryDTO getAccountHistory(String accountId, int page, int size){
        AccountDTO account = accountFeignClient.findById(accountId);
        return findAccountHistoryDTO(accountId, page, size, account.id(), account.balance());
    }

    @Override
    public OperationDTO getOperationById(Long id) throws OperationNotFoundException {
        Operation operation = operationRepository.findById(id)
                .orElseThrow(()-> new OperationNotFoundException("Operation Not Found"));
        log.info("operation found");
        return fromOperation(operation);
    }


    private AccountHistoryDTO findAccountHistoryDTO(String accountId, int page, int size, String id, BigDecimal balance) {
        Page<Operation> accountOperations = operationRepository.findByBankAccountIdOrderByDateDesc(accountId, PageRequest.of(page, size));
        List<OperationDTO> operationDTOList = accountOperations.getContent().stream().map(this::fromOperation).toList();
        log.info("operation(s) pages found");
        return new AccountHistoryDTO(id, balance, page, accountOperations.getTotalPages(), size, operationDTOList);
    }

    private OperationDTO fromOperation(Operation operation){
        return new OperationDTO(operation.getId(), operation.getDate(), operation.getAmount(), operation.getType(), operation.getDescription());
    }

    private CreditDTO saveCreditDTO(CreditDTO creditDTO, AccountDTO account, String id) {
        Operation operation = Operation.builder()
                .amount(creditDTO.amount())
                .bankAccountId(account.id())
                .date(new Date())
                .description(creditDTO.description())
                .type(OperationType.CREDIT)
                .build();
        Operation operationSaved = operationRepository.save(operation);
        log.info("account well credited");
        return new CreditDTO(id, operationSaved.getAmount(), operationSaved.getDescription());
    }

    private DebitDTO saveDebitDTO(DebitDTO debitDTO, AccountDTO account, String id) {
        Operation operation = Operation.builder()
                .amount(debitDTO.amount())
                .bankAccountId(account.id())
                .date(new Date())
                .description(debitDTO.description())
                .type(OperationType.CREDIT)
                .build();
        Operation operationSaved = operationRepository.save(operation);
        log.info("account well debited");
        return new DebitDTO(id, operationSaved.getAmount(), operationSaved.getDescription());
    }

}
