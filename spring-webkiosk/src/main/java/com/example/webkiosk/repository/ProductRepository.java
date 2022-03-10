package com.example.webkiosk.repository;

import com.example.webkiosk.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product WHERE category_id = :categoryId", nativeQuery = true)
    Page<Product> getProductsByCategoryId(@Param("categoryId") Long categoryId, Pageable pageable);

}
