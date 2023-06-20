package com.example.ordermanagement.dto;

import com.example.ordermanagement.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private long id;
    private Customer customer;
    private Date orderedAt;
}
