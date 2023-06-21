package com.example.ordermanagement.service;


import com.example.ordermanagement.dto.Customer.CustomerDto;
import com.example.ordermanagement.dto.Order.OrderDto;
import com.example.ordermanagement.dto.Order.OrderInsertDto;
import com.example.ordermanagement.dto.Order.OrderUpdateDto;

import java.util.List;

public interface OrderService {
    public OrderDto getById(long id);
    public OrderDto insert(OrderInsertDto orderInsertDto);
    public OrderDto update(long id, OrderUpdateDto orderUpdateDto);
    public boolean delete(long id);

    List<OrderDto> getAllOrdersByCustomerId(long id);
}
