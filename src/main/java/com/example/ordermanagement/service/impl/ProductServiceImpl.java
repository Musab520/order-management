package com.example.ordermanagement.service.impl;

import com.example.ordermanagement.dto.Product.ProductDto;
import com.example.ordermanagement.dto.Product.ProductInsertDto;
import com.example.ordermanagement.dto.Product.ProductUpdateDto;
import com.example.ordermanagement.entity.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.ordermanagement.repository.ProductRepository;
import com.example.ordermanagement.service.ProductService;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    @Override
    public ProductDto getById(long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return modelMapper.map(product.get(), ProductDto.class);
        } else {
            return null;
        }
    }

    @Override
    public ProductDto insert(@RequestBody @Valid ProductInsertDto productInsertDto) {
        Product product = modelMapper.map(productInsertDto, Product.class);
        Product newProduct = productRepository.save(product);
        return modelMapper.map(newProduct, ProductDto.class);
    }

    @Override
    public ProductDto update(long id, ProductUpdateDto productUpdateDto) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            modelMapper.map(productUpdateDto, product.get());
            Product updatedProduct = productRepository.save(product.get());
            return modelMapper.map(updatedProduct, ProductDto.class);
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return true;
        }
        return false;
    }
}
