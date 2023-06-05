package com.brodygaudel.customerservice.services;

import com.brodygaudel.customerservice.dto.CustomerDTO;
import com.brodygaudel.customerservice.exceptions.CommandRejectedException;
import com.brodygaudel.customerservice.exceptions.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO) throws CommandRejectedException;
    CustomerDTO updateCustomer(CustomerDTO customerDTO) throws CustomerNotFoundException;
    List<CustomerDTO> getAllCustomers();
    List<CustomerDTO> searchCustomers(String keyword);
    CustomerDTO getCustomerById(Long id) throws CustomerNotFoundException;
    void deleteCustomerById(Long id);
}
