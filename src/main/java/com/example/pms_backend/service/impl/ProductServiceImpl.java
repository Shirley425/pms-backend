package com.example.pms_backend.service.impl;

import com.example.pms_backend.Mapper.ProductMapper;
import com.example.pms_backend.dto.ProductDto;
import com.example.pms_backend.entity.Product;
import com.example.pms_backend.repository.ProductRepository;
import com.example.pms_backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        product.setProductId(null);
        return ProductMapper.mapToProductDto(productRepository.save(product));
    }

    @Override
    public ProductDto getProductById(Long productId) {
        return ProductMapper.mapToProductDto(productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId)));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(ProductMapper::mapToProductDto).toList();
    }

    @Override
    public List<ProductDto> searchProducts(String keyword) {
        if (keyword == null || keyword.isBlank()) return getAllProducts();
        return productRepository
                .findByProductNameContainingIgnoreCaseOrDepartmentContainingIgnoreCase(keyword, keyword)
                .stream().map(ProductMapper::mapToProductDto).toList();
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto productDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));
        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        product.setDepartment(productDto.getDepartment());
        return ProductMapper.mapToProductDto(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));
        productRepository.delete(product);
    }
}
