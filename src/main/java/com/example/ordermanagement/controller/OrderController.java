package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.Order.OrderInsertDto;
import com.example.ordermanagement.dto.Order.OrderUpdateDto;
import com.example.ordermanagement.service.OrderService;
import com.example.ordermanagement.dto.Order.OrderDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {

    private final OrderService orderService;

    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable long id) {
        OrderDto orderDto = orderService.getById(id);
        if (orderDto != null) {
            return ResponseEntity.ok(orderDto);
        } else {
            return ResponseEntity.badRequest().body(new OrderDto());
        }
    }

    @PostMapping
    public ResponseEntity<OrderDto> insertOrder(@RequestBody @Valid OrderInsertDto orderInsertDto) {
        OrderDto orderDto = orderService.insert(orderInsertDto);
        return ResponseEntity.ok(orderDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable long id, @RequestBody @Valid OrderUpdateDto orderUpdateDto) {
        OrderDto orderDto = orderService.update(id, orderUpdateDto);
        if (orderDto != null) {
            return ResponseEntity.ok(orderDto);
        } else {
            return ResponseEntity.badRequest().body(new OrderDto());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> updateOrder(@PathVariable long id) {
        boolean success = orderService.delete(id);
        if (success) {
            return ResponseEntity.ok("Deleted Order Successfully");
        } else {
            return ResponseEntity.badRequest().body("Error Occurred with Deletion");
        }
    }


}
