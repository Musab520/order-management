package com.example.ordermanagement.dto;

import com.example.ordermanagement.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderUpdateDto {
    private Customer customer;
    private Date orderedAt;
}
