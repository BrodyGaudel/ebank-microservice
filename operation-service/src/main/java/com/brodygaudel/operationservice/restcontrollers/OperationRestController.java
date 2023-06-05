package com.brodygaudel.operationservice.restcontrollers;

import com.brodygaudel.operationservice.dtos.*;
import com.brodygaudel.operationservice.exceptions.BalanceNotSufficientException;
import com.brodygaudel.operationservice.exceptions.BankAccountNotFoundException;
import com.brodygaudel.operationservice.exceptions.OperationNotFoundException;
import com.brodygaudel.operationservice.services.OperationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OperationRestController {

    private final OperationService operationService;

    public OperationRestController(OperationService operationService) {
        this.operationService = operationService;
    }

    @PostMapping("/debit")
    public DebitDTO debit(@RequestBody DebitDTO debitDTO) throws BankAccountNotFoundException, BalanceNotSufficientException{
        return operationService.debit(debitDTO);
    }

    @PostMapping("/credit")
    public CreditDTO credit(@RequestBody CreditDTO creditDTO) throws BankAccountNotFoundException{
        return operationService.credit(creditDTO);
    }

    @PostMapping("/transfer")
    public TransferDTO transfer(@RequestBody TransferDTO transferDTO) throws BankAccountNotFoundException, BalanceNotSufficientException{
        return operationService.transfer(transferDTO);
    }

    @GetMapping("/list/{accountId}")
    public List<OperationDTO> getAllOperationsByAccountId(@PathVariable String accountId){
        return operationService.getAllOperationsByAccountId(accountId);
    }

    @GetMapping("/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(@PathVariable String accountId,
                                               @RequestParam(name ="page", defaultValue = "0") int page,
                                               @RequestParam(name ="size", defaultValue = "5") int size) throws BankAccountNotFoundException{
        return operationService.getAccountHistory(accountId, page, size);
    }

    @GetMapping("/get/{id}")
    public OperationDTO getOperationById(@PathVariable Long id) throws OperationNotFoundException{
        return operationService.getOperationById(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
