package com.example.ordermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateDto {
    private String firstName;
    private String lastName;
    private Date bornAt;
}
