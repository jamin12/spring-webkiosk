package com.example.webkiosk.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import com.example.webkiosk.entity.Category;
import com.example.webkiosk.repository.CategoryRepository;
import com.example.webkiosk.repository.CategoryRepositoryTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class CategoryServiceTest {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void testCategoryCreate() {
        // 입력 데이터 준비
        Integer user_num = 1;
        String category_name = "테스트";
        // 실제 수행
        Category category = categoryService.categoryCreate(new Category(user_num, category_name));
        // 예상하기
        Category expected = new Category(1, user_num, category_name);
        // 검증
        assertEquals(expected, category);
    }

    @Test
    void testCategoryUpdtae() {
        // 입력 데이터 준비
        Integer user_num = 1;
        String category_name = "테스트";
        // 실제 수행
        Category category = categoryService.categoryUpdtae(1, new Category(1, user_num, category_name));
        // 예상하기
        Category expected = new Category(1, user_num, category_name);
        // 검증
        assertEquals(expected, category);
    }

    @Test
    void testCategoryDelete() {
        // 입력 데이터 준비
        Integer category_id = 1;
        // 예상하기
        Category expected = categoryRepository.findById(category_id).orElse(null);
        // 실제 수행
        Category category = categoryService.categoryDelete(category_id);
        // 검증
        assertEquals(expected, category);
    }
}
