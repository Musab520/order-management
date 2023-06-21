package com.example.ordermanagement.service;


import com.example.ordermanagement.dto.Order.OrderDto;
import com.example.ordermanagement.dto.Product.ProductDto;
import com.example.ordermanagement.dto.ProductOrder.ProductOrderDto;
import com.example.ordermanagement.dto.ProductOrder.ProductOrderInsertDto;
import com.example.ordermanagement.dto.ProductOrder.ProductOrderUpdateDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductOrderService {
    public ProductOrderDto getById(long id);
    public ProductOrderDto insert(ProductOrderInsertDto productOrderInsertDto);
    public ProductOrderDto update(long id, ProductOrderUpdateDto productOrderUpdateDto);
    public boolean delete(long id);

    List<ProductDto> getAllProductsByOrderId(OrderDto order);
}
