package com.example.ordermanagement.service;


import com.example.ordermanagement.dto.Stock.StockDto;
import com.example.ordermanagement.dto.Stock.StockInsertDto;
import com.example.ordermanagement.dto.Stock.StockUpdateDto;

public interface StockService {
    public StockDto getById(long id);
    public StockDto insert(StockInsertDto stockInsertDto);
    public StockDto update(long id, StockUpdateDto stockUpdateDto);
    public boolean delete(long id);
}
