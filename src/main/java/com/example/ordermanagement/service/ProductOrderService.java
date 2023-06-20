package com.example.ordermanagement.service;


import com.example.ordermanagement.dto.ProductOrder.ProductOrderDto;
import com.example.ordermanagement.dto.ProductOrder.ProductOrderInsertDto;
import com.example.ordermanagement.dto.ProductOrder.ProductOrderUpdateDto;

public interface ProductOrderService {
    public ProductOrderDto getById(long id);
    public ProductOrderDto insert(ProductOrderInsertDto productOrderInsertDto);
    public ProductOrderDto update(long id, ProductOrderUpdateDto productOrderUpdateDto);
    public boolean delete(long id);
}
