package com.example.ordermanagement.service;


import com.example.ordermanagement.dto.CustomerDto;
import com.example.ordermanagement.dto.CustomerInsertDto;
import com.example.ordermanagement.dto.CustomerUpdateDto;

public interface CustomerService {
    public CustomerDto getById(long id);
    public CustomerDto insert(CustomerInsertDto customerInsertDto);
    public CustomerDto update(long id, CustomerUpdateDto customerUpdateDto);
    public boolean delete(long id);
}
