package com.example.ordermanagement.dto.Stock;

import com.example.ordermanagement.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockInsertDto {
    private int quantity;
    private Date updateAt;
    private Product product;
}
