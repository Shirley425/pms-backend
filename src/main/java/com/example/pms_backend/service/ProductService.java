package com.example.pms_backend.service;

import com.example.pms_backend.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto getProductById(Long productId);
    List<ProductDto> getAllProducts();
    List<ProductDto> searchProducts(String keyword);
    ProductDto updateProduct(Long productId, ProductDto productDto);
    void deleteProduct(Long productId);
}
