package com.brodygaudel.accountservice.feign;

import com.brodygaudel.accountservice.dtos.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerFeignService {

    @GetMapping("/api/v1/get/{id}")
    CustomerDTO getCustomerById(@PathVariable  Long id);
}
