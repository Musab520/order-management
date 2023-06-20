package com.example.ordermanagement.dto.Order;

import com.example.ordermanagement.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInsertDto {
    private Customer customer;
    private Date orderedAt;
}
