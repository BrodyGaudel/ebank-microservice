package com.brodygaudel.customerservice.services.impl;

import com.brodygaudel.customerservice.dto.CustomerDTO;
import com.brodygaudel.customerservice.entities.Customer;
import com.brodygaudel.customerservice.exceptions.CommandRejectedException;
import com.brodygaudel.customerservice.exceptions.CustomerNotFoundException;
import com.brodygaudel.customerservice.mapping.Mappers;
import com.brodygaudel.customerservice.repositories.CustomerRepository;
import com.brodygaudel.customerservice.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final Mappers mappers;

    public CustomerServiceImpl(CustomerRepository customerRepository, Mappers mappers) {
        this.customerRepository = customerRepository;
        this.mappers = mappers;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) throws CommandRejectedException {
        Boolean cinExist = customerRepository.checkIfCinExists(customerDTO.cin());
        if(Boolean.TRUE.equals(cinExist)){
            throw new CommandRejectedException("cin already used by another customer");
        }
        Boolean emailExist = customerRepository.checkIfEmailExists(customerDTO.email());
        if(Boolean.TRUE.equals(emailExist)){
            throw new CommandRejectedException("email already used by another customer");
        }
        Boolean phoneExist = customerRepository.checkIfPhoneExists(customerDTO.phone());
        if(Boolean.TRUE.equals(phoneExist)){
            throw new CommandRejectedException("phone already used by another customer");
        }
        Customer customer = mappers.fromCustomerDTO(customerDTO);
        Customer customerSaved = customerRepository.save(customer);
        log.info("customer saved successfully");
        return mappers.fromCustomer(customerSaved);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerDTO.id())
                .orElseThrow( () -> new CustomerNotFoundException("the customer you want to update was not found"));
        Customer c = mappers.fromCustomerDTO(customerDTO);
        c.setId(customer.getId());
        Customer customerUpdated = customerRepository.save(c);
        log.info("customer updated successfully");
        return mappers.fromCustomer(customerUpdated);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        log.info("customer(s) found");
        return mappers.fromListOfCustomers(customers);
    }

    @Override
    public List<CustomerDTO> searchCustomers(String keyword) {
        List<Customer> customers = customerRepository.search(keyword);
        log.info("customer(s) found by keyword");
        return mappers.fromListOfCustomers(customers);
    }

    @Override
    public CustomerDTO getCustomerById(Long id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow( () -> new CustomerNotFoundException("customer not found"));
        log.info("customer found by id");
        return mappers.fromCustomer(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
        log.info("customer deleted");
    }
}
