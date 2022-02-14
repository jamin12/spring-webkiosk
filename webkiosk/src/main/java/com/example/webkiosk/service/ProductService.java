//강경민
package com.example.webkiosk.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.webkiosk.entity.Product;
import com.example.webkiosk.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
public interface ProductService {

    final ProductRepository productRepository;

    /**
     * 접속한 회원의 카테고리에 따른 상품 목록 가져오기
     */
    public Page<Product> getProductsByCategoryId (Long categoryId, Pageable pageable) {
        Page<Product> categoryProduct = productRepository.getProductsByCategoryId(categoryId, pageable);
        return categoryProduct;
    }
}
