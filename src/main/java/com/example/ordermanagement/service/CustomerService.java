package com.example.ordermanagement.service;


import com.example.ordermanagement.dto.Customer.CustomerDto;
import com.example.ordermanagement.dto.Customer.CustomerInsertDto;
import com.example.ordermanagement.dto.Customer.CustomerUpdateDto;

public interface CustomerService {
    public CustomerDto getById(long id);
    public CustomerDto insert(CustomerInsertDto customerInsertDto);
    public CustomerDto update(long id, CustomerUpdateDto customerUpdateDto);
    public boolean delete(long id);
}
