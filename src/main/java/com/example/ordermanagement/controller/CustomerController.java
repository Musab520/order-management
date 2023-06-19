package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.CustomerInsertDto;
import com.example.ordermanagement.service.CustomerService;
import com.example.ordermanagement.dto.CustomerDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable long id) {
        CustomerDto customerDto = customerService.getById(id);
        if (customerDto != null) {
            return ResponseEntity.ok(customerDto);
        } else {
            return ResponseEntity.badRequest().body(new CustomerDto());
        }
    }

    @PostMapping
    public ResponseEntity<CustomerDto> insertCustomer(@RequestBody @Valid CustomerInsertDto customerInsertDto) {
        CustomerDto customerDto = customerService.insert(customerInsertDto);
        return ResponseEntity.ok(customerDto);
    }
}
