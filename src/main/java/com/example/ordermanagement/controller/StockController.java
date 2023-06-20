package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.Stock.StockInsertDto;
import com.example.ordermanagement.dto.Stock.StockUpdateDto;
import com.example.ordermanagement.service.StockService;
import com.example.ordermanagement.dto.Stock.StockDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StockController {

    private final StockService stockService;

    @GetMapping("{id}")
    public ResponseEntity<StockDto> getStock(@PathVariable long id) {
        StockDto stockDto = stockService.getById(id);
        if (stockDto != null) {
            return ResponseEntity.ok(stockDto);
        } else {
            return ResponseEntity.badRequest().body(new StockDto());
        }
    }

    @PostMapping
    public ResponseEntity<StockDto> insertStock(@RequestBody @Valid StockInsertDto stockInsertDto) {
        StockDto stockDto = stockService.insert(stockInsertDto);
        return ResponseEntity.ok(stockDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<StockDto> updateStock(@PathVariable long id, @RequestBody @Valid StockUpdateDto stockUpdateDto) {
        StockDto stockDto = stockService.update(id, stockUpdateDto);
        if (stockDto != null) {
            return ResponseEntity.ok(stockDto);
        } else {
            return ResponseEntity.badRequest().body(new StockDto());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> updateStock(@PathVariable long id) {
        boolean success = stockService.delete(id);
        if (success) {
            return ResponseEntity.ok("Deleted Stock Successfully");
        } else {
            return ResponseEntity.badRequest().body("Error Occurred with Deletion");
        }
    }


}
