package com.example.pms_backend.controller;

import com.example.pms_backend.dto.ProductDto;
import com.example.pms_backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProducts(@ModelAttribute ProductDto productDto) {
        if (productDto.getProductId() != null) {
            return ResponseEntity.ok(productService.getProductById(productDto.getProductId()));
        }
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> searchProducts(@ModelAttribute ProductDto productDto) {
        String keyword = productDto.getProductName() != null
                ? productDto.getProductName() : productDto.getDepartment();
        return ResponseEntity.ok(productService.searchProducts(keyword));
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@ModelAttribute ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDto));
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@ModelAttribute ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(productDto.getProductId(), productDto));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(@ModelAttribute ProductDto productDto) {
        productService.deleteProduct(productDto.getProductId());
        return ResponseEntity.noContent().build();
    }
}
