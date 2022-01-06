package com.example.webkiosk.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.example.webkiosk.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    @Query(value = "select * from category where user_num = :user_num", nativeQuery = true)
    List<Category> findByUserId(@Param("user_num") int user_num);
}
