package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.Order.OrderDto;
import com.example.ordermanagement.dto.Product.ProductDto;
import com.example.ordermanagement.dto.ProductOrder.ProductOrderInsertDto;
import com.example.ordermanagement.dto.ProductOrder.ProductOrderUpdateDto;
import com.example.ordermanagement.service.ProductOrderService;
import com.example.ordermanagement.dto.ProductOrder.ProductOrderDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productOrder")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//@Api(tags = "Product Order")
public class ProductOrderController {

    private final ProductOrderService productOrderService;
    //@ApiOperation("Get a product order by ID")
    @GetMapping("{id}")
    public ResponseEntity<ProductOrderDto> getProductOrder(@PathVariable long id) {
        ProductOrderDto productOrderDto = productOrderService.getById(id);
        if (productOrderDto != null) {
            return ResponseEntity.ok(productOrderDto);
        } else {
            return ResponseEntity.badRequest().body(new ProductOrderDto());
        }
    }
    //@ApiOperation("Insert a product order")
    @PostMapping
    public ResponseEntity<ProductOrderDto> insertProductOrder(@RequestBody @Valid ProductOrderInsertDto productOrderInsertDto) {
        ProductOrderDto productOrderDto = productOrderService.insert(productOrderInsertDto);
        return ResponseEntity.ok(productOrderDto);
    }
    //@ApiOperation("Update an existing Product Order")
    @PutMapping("{id}")
    public ResponseEntity<ProductOrderDto> updateProductOrder(@PathVariable long id, @RequestBody @Valid ProductOrderUpdateDto productOrderUpdateDto) {
        ProductOrderDto productOrderDto = productOrderService.update(id, productOrderUpdateDto);
        if (productOrderDto != null) {
            return ResponseEntity.ok(productOrderDto);
        } else {
            return ResponseEntity.badRequest().body(new ProductOrderDto());
        }
    }
    //@ApiOperation("Delete a product order by ID")
    @DeleteMapping("{id}")
    public ResponseEntity<String> updateProductOrder(@PathVariable long id) {
        boolean success = productOrderService.delete(id);
        if (success) {
            return ResponseEntity.ok("Deleted ProductOrder Successfully");
        } else {
            return ResponseEntity.badRequest().body("Error Occurred with Deletion");
        }
    }
    @GetMapping("/order/{id}/products")
    public ResponseEntity<List<ProductDto>> getAllProductsByOrderId(@RequestBody @Valid OrderDto order) {
        List<ProductDto> productDtos = productOrderService.getAllProductsByOrderId(order);
        return ResponseEntity.ok(productDtos);
    }

}
