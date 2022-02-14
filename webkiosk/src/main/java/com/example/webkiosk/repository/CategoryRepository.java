package com.example.webkiosk.repository;

import com.example.webkiosk.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM category WHERE user_num = :userNum", nativeQuery = true)
    Page<Category> getCategoriesByUserNum(@Param("userNum") Long userNum, Pageable pageable);

    @Query(value = "SELECT category_id FROM category WHERE user_num = :userNum", nativeQuery = true)
    ArrayList<Long> getCategoryIdList(@Param("userNum") Long userNum);

    @Query(value = "SELECT * FROM category WHERE user_num = :userNum", nativeQuery = true)
    List<Category> getCategoryNamesByUserNum(@Param("userNum") Long userNum);

    List<Category> findByUserNum(Long userNum);
}
