package com.example.ordermanagement.dto.Stock;

import com.example.ordermanagement.entity.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {
    private long id;
    private int quantity;
    private Date updateAt;
    private Product product;
}
