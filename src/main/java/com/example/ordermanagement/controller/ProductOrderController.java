package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.ProductOrder.ProductOrderInsertDto;
import com.example.ordermanagement.dto.ProductOrder.ProductOrderUpdateDto;
import com.example.ordermanagement.service.ProductOrderService;
import com.example.ordermanagement.dto.ProductOrder.ProductOrderDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productOrder")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    @GetMapping("{id}")
    public ResponseEntity<ProductOrderDto> getProductOrder(@PathVariable long id) {
        ProductOrderDto productOrderDto = productOrderService.getById(id);
        if (productOrderDto != null) {
            return ResponseEntity.ok(productOrderDto);
        } else {
            return ResponseEntity.badRequest().body(new ProductOrderDto());
        }
    }

    @PostMapping
    public ResponseEntity<ProductOrderDto> insertProductOrder(@RequestBody @Valid ProductOrderInsertDto productOrderInsertDto) {
        ProductOrderDto productOrderDto = productOrderService.insert(productOrderInsertDto);
        return ResponseEntity.ok(productOrderDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductOrderDto> updateProductOrder(@PathVariable long id, @RequestBody @Valid ProductOrderUpdateDto productOrderUpdateDto) {
        ProductOrderDto productOrderDto = productOrderService.update(id, productOrderUpdateDto);
        if (productOrderDto != null) {
            return ResponseEntity.ok(productOrderDto);
        } else {
            return ResponseEntity.badRequest().body(new ProductOrderDto());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> updateProductOrder(@PathVariable long id) {
        boolean success = productOrderService.delete(id);
        if (success) {
            return ResponseEntity.ok("Deleted ProductOrder Successfully");
        } else {
            return ResponseEntity.badRequest().body("Error Occurred with Deletion");
        }
    }


}
