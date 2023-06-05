package com.brodygaudel.customerservice.mapping;

import com.brodygaudel.customerservice.dto.CustomerDTO;
import com.brodygaudel.customerservice.entities.Customer;

import java.util.List;

public interface Mappers {
    Customer fromCustomerDTO(CustomerDTO customerDTO);
    CustomerDTO fromCustomer(Customer customer);
    List<CustomerDTO> fromListOfCustomers(List<Customer> customers);
}
