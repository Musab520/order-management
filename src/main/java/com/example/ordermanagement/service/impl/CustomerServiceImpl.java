package com.example.ordermanagement.service.impl;

import com.example.ordermanagement.dto.CustomerDto;
import com.example.ordermanagement.dto.CustomerInsertDto;
import com.example.ordermanagement.dto.CustomerUpdateDto;
import com.example.ordermanagement.entity.Customer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.ordermanagement.repository.CustomerRepository;
import com.example.ordermanagement.service.CustomerService;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    @Override
    public CustomerDto getById(long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return modelMapper.map(customer.get(), CustomerDto.class);
        } else {
            return null;
        }
    }

    @Override
    public CustomerDto insert(@RequestBody @Valid CustomerInsertDto customerInsertDto) {
        Customer customer = modelMapper.map(customerInsertDto, Customer.class);
        Customer newCustomer = customerRepository.save(customer);
        return modelMapper.map(newCustomer, CustomerDto.class);
    }

    @Override
    public CustomerDto update(long id, CustomerUpdateDto customerUpdateDto) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            modelMapper.map(customerUpdateDto, customer.get());
            Customer updatedCustomer = customerRepository.save(customer.get());
            return modelMapper.map(updatedCustomer, CustomerDto.class);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.delete(customer.get());
        }
    }
}
