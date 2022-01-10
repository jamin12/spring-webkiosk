package com.example.webkiosk.repository;

import java.util.List;

import com.example.webkiosk.entity.Product;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // 회원의 한 카테고리 상품 가져오기
    List<Product> findByCategoryNumAndUserNum(@Param("categoryNum") Integer categoryNum,
            @Param("userNum") Integer userNum);
}
