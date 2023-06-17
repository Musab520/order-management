package service;


import dto.CustomerDto;
import dto.CustomerInsertDto;
import dto.CustomerUpdateDto;

public interface CustomerService {
    public CustomerDto getById(long id);
    public CustomerDto insert(CustomerInsertDto customerInsertDto);
    public CustomerDto update(CustomerUpdateDto customerUpdateDto);
    public void delete(long id);
}
