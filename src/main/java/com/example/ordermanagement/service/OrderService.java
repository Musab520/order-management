package com.example.ordermanagement.service;


import com.example.ordermanagement.dto.OrderDto;
import com.example.ordermanagement.dto.OrderInsertDto;
import com.example.ordermanagement.dto.OrderUpdateDto;

public interface OrderService {
    public OrderDto getById(long id);
    public OrderDto insert(OrderInsertDto orderInsertDto);
    public OrderDto update(long id, OrderUpdateDto orderUpdateDto);
    public boolean delete(long id);
}
