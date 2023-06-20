package com.example.ordermanagement.service.impl;

import com.example.ordermanagement.dto.ProductOrder.ProductOrderDto;
import com.example.ordermanagement.dto.ProductOrder.ProductOrderInsertDto;
import com.example.ordermanagement.dto.ProductOrder.ProductOrderUpdateDto;
import com.example.ordermanagement.entity.ProductOrder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.ordermanagement.repository.ProductOrderRepository;
import com.example.ordermanagement.service.ProductOrderService;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductOrderServiceImpl implements ProductOrderService {
    private final ProductOrderRepository productOrderRepository;
    private final ModelMapper modelMapper;
    @Override
    public ProductOrderDto getById(long id) {
        Optional<ProductOrder> productOrder = productOrderRepository.findById(id);
        if (productOrder.isPresent()) {
            return modelMapper.map(productOrder.get(), ProductOrderDto.class);
        } else {
            return null;
        }
    }

    @Override
    public ProductOrderDto insert(@RequestBody @Valid ProductOrderInsertDto productOrderInsertDto) {
        ProductOrder productOrder = modelMapper.map(productOrderInsertDto, ProductOrder.class);
        ProductOrder newProductOrder = productOrderRepository.save(productOrder);
        return modelMapper.map(newProductOrder, ProductOrderDto.class);
    }

    @Override
    public ProductOrderDto update(long id, ProductOrderUpdateDto productOrderUpdateDto) {
        Optional<ProductOrder> productOrder = productOrderRepository.findById(id);
        if (productOrder.isPresent()) {
            modelMapper.map(productOrderUpdateDto, productOrder.get());
            ProductOrder updatedProductOrder = productOrderRepository.save(productOrder.get());
            return modelMapper.map(updatedProductOrder, ProductOrderDto.class);
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(long id) {
        Optional<ProductOrder> productOrder = productOrderRepository.findById(id);
        if (productOrder.isPresent()) {
            productOrderRepository.delete(productOrder.get());
            return true;
        }
        return false;
    }
}
