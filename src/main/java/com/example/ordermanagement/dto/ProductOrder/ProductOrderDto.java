package com.example.ordermanagement.dto.ProductOrder;

import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.entity.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderDto {
    private long id;
    private Product product;
    private Order order;
    private int quantity;
    private double price;
    private double vat;
}
