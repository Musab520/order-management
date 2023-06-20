package com.example.ordermanagement.dto.ProductOrder;

import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderInsertDto {
    private Product product;
    private Order order;
    private int quantity;
    private double price;
    private double vat;
}
