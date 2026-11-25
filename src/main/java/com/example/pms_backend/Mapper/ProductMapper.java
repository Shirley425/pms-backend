package com.example.pms_backend.Mapper;

import com.example.pms_backend.dto.ProductDto;
import com.example.pms_backend.entity.Product;

public final class ProductMapper {
    private ProductMapper() {}

    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(product.getProductId(), product.getProductName(),
                product.getProductPrice(), product.getDepartment());
    }

    public static Product mapToProduct(ProductDto productDto) {
        return new Product(productDto.getProductId(), productDto.getProductName(),
                productDto.getProductPrice(), productDto.getDepartment());
    }
}
