package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.Customer.CustomerInsertDto;
import com.example.ordermanagement.dto.Customer.CustomerUpdateDto;
import com.example.ordermanagement.service.CustomerService;
import com.example.ordermanagement.dto.Customer.CustomerDto;

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
    //Get customer by ID
    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable long id) {
        CustomerDto customerDto = customerService.getById(id);
        if (customerDto != null) {
            return ResponseEntity.ok(customerDto);
        } else {
            return ResponseEntity.badRequest().body(new CustomerDto());
        }
    }
    //Insert a new customer
    @PostMapping
    public ResponseEntity<CustomerDto> insertCustomer(@RequestBody @Valid CustomerInsertDto customerInsertDto) {
        CustomerDto customerDto = customerService.insert(customerInsertDto);
        return ResponseEntity.ok(customerDto);
    }
    //Update an existing customer
    @PutMapping("{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable long id, @RequestBody @Valid CustomerUpdateDto customerUpdateDto) {
        CustomerDto customerDto = customerService.update(id, customerUpdateDto);
        if (customerDto != null) {
            return ResponseEntity.ok(customerDto);
        } else {
            return ResponseEntity.badRequest().body(new CustomerDto());
        }
    }
    //Delete a customer by ID
    @DeleteMapping("{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable long id) {
        boolean success = customerService.delete(id);
        if (success) {
            return ResponseEntity.ok("Deleted Customer Successfully");
        } else {
            return ResponseEntity.badRequest().body("Error Occurred with Deletion");
        }
    }


}
