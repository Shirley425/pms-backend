package com.example.pms_backend.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long productId;

    private String productName;

    private BigDecimal productPrice;

    private String department;
}
