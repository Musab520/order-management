package com.example.ordermanagement.service;


import com.example.ordermanagement.dto.Product.ProductDto;
import com.example.ordermanagement.dto.Product.ProductInsertDto;
import com.example.ordermanagement.dto.Product.ProductUpdateDto;

public interface ProductService {
    public ProductDto getById(long id);
    public ProductDto insert(ProductInsertDto productInsertDto);
    public ProductDto update(long id, ProductUpdateDto productUpdateDto);
    public boolean delete(long id);
}
