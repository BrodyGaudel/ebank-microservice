package com.brodygaudel.operationservice.feign;

import com.brodygaudel.operationservice.feign.dtos.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountFeignClient {
    @GetMapping("/api/v1/get/{id}")
    BankAccountDTO getById(@PathVariable String id);

    @GetMapping("/api/v1/find/{id}")
    AccountDTO findById(@PathVariable String id);

    @PutMapping("/api/v1/update/current")
    CurrentAccountDTO updateCurrentAccount(@RequestBody UpdateCurrentAccountDTO accountDTO);

    @PutMapping("/api/v1/update/saving")
    SavingAccountDTO updateSavingAccount(@RequestBody UpdateSavingAccountDTO savingAccountDTO);
}
