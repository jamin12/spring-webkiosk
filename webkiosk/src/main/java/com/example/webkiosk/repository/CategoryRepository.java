package com.example.webkiosk.repository;

import com.example.webkiosk.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM category c LEFT JOIN user u ON c.user_num = u.user_num AND c.user_num = :userNum", nativeQuery = true)
    Page<Category> findCategoriesByUserNum(@Param("userNum") Long userNum, Pageable pageable);

    @Query(value = "SELECT category_id FROM category c LEFT JOIN user u ON c.user_num = u.user_num AND c.user_num = :userNum", nativeQuery = true)
    ArrayList<Long> getCategoryIdList(@Param("userNum") Long userNum);
}
