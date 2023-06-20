package com.example.ordermanagement.dto.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInsertDto {
    private String slug;
    private String name;
    private String reference;
    private double price;
    private double vat;
    private boolean stockable;
}
