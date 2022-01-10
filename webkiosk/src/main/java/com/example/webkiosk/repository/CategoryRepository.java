package com.example.webkiosk.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.example.webkiosk.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    // 유저카테리 가져오기
    List<Category> findByuserNum(@Param("userNum") Integer userNum);
}
