package com.example.webkiosk.service;

import com.example.webkiosk.entity.Product;
import com.example.webkiosk.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {
    final ProductRepository productRepository;

    /**
     * 접속한 회원의 카테고리에 따른 상품 목록 가져오기
     */
    public Page<Product> getProductsByCategoryId(Long categoryId, Pageable pageable) {
        Page<Product> categoryProduct = productRepository.getProductsByCategoryId(categoryId, pageable);
        return categoryProduct;
    }
}
