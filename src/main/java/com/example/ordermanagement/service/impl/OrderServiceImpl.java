package com.example.ordermanagement.service.impl;

import com.example.ordermanagement.dto.Customer.CustomerDto;
import com.example.ordermanagement.dto.Order.OrderDto;
import com.example.ordermanagement.dto.Order.OrderInsertDto;
import com.example.ordermanagement.dto.Order.OrderUpdateDto;
import com.example.ordermanagement.entity.Customer;
import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.ordermanagement.repository.OrderRepository;
import com.example.ordermanagement.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    @Override
    public OrderDto getById(long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return modelMapper.map(order.get(), OrderDto.class);
        } else {
            return null;
        }
    }

    @Override
    public OrderDto insert(@RequestBody @Valid OrderInsertDto orderInsertDto) {
        Order order = modelMapper.map(orderInsertDto, Order.class);
        Order newOrder = orderRepository.save(order);
        return modelMapper.map(newOrder, OrderDto.class);
    }

    @Override
    public OrderDto update(long id, OrderUpdateDto orderUpdateDto) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            modelMapper.map(orderUpdateDto, order.get());
            Order updatedOrder = orderRepository.save(order.get());
            return modelMapper.map(updatedOrder, OrderDto.class);
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            orderRepository.delete(order.get());
            return true;
        }
        return false;
    }

    @Override
    public List<OrderDto> getAllOrdersByCustomerId(long id) {
        List<Order> orders = orderRepository.getAllOrdersByCustomerId(id);
        List<OrderDto> orderDtos = orders.stream()
                .map(source -> modelMapper.map(source, OrderDto.class))
                .collect(Collectors.toList());
        return orderDtos;
    }
}
