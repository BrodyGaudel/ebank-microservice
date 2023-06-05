package com.brodygaudel.customerservice.mapping.impl;

import com.brodygaudel.customerservice.dto.CustomerDTO;
import com.brodygaudel.customerservice.entities.Customer;
import com.brodygaudel.customerservice.mapping.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MappersImpl implements Mappers {

    @Override
    public Customer fromCustomerDTO(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }

    @Override
    public CustomerDTO fromCustomer(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getFirstname(),
                customer.getName(),
                customer.getPlaceOfBirth(),
                customer.getDateOfBirth(),
                customer.getNationality(),
                customer.getCin(),
                customer.getEmail(),
                customer.getPhone()
        );
    }

    @Override
    public List<CustomerDTO> fromListOfCustomers(List<Customer> customers) {
        return customers.stream().map(this::fromCustomer).toList();
    }
}
