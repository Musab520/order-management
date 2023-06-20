package com.example.ordermanagement.service.impl;

import com.example.ordermanagement.dto.Stock.StockDto;
import com.example.ordermanagement.dto.Stock.StockInsertDto;
import com.example.ordermanagement.dto.Stock.StockUpdateDto;
import com.example.ordermanagement.entity.Stock;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.ordermanagement.repository.StockRepository;
import com.example.ordermanagement.service.StockService;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;
    private final ModelMapper modelMapper;
    @Override
    public StockDto getById(long id) {
        Optional<Stock> stock = stockRepository.findById(id);
        if (stock.isPresent()) {
            return modelMapper.map(stock.get(), StockDto.class);
        } else {
            return null;
        }
    }

    @Override
    public StockDto insert(@RequestBody @Valid StockInsertDto stockInsertDto) {
        Stock stock = modelMapper.map(stockInsertDto, Stock.class);
        Stock newStock = stockRepository.save(stock);
        return modelMapper.map(newStock, StockDto.class);
    }

    @Override
    public StockDto update(long id, StockUpdateDto stockUpdateDto) {
        Optional<Stock> stock = stockRepository.findById(id);
        if (stock.isPresent()) {
            modelMapper.map(stockUpdateDto, stock.get());
            Stock updatedStock = stockRepository.save(stock.get());
            return modelMapper.map(updatedStock, StockDto.class);
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(long id) {
        Optional<Stock> stock = stockRepository.findById(id);
        if (stock.isPresent()) {
            stockRepository.delete(stock.get());
            return true;
        }
        return false;
    }
}
