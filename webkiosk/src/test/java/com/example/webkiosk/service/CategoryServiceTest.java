package com.example.webkiosk.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import com.example.webkiosk.entity.Category;
import com.example.webkiosk.repository.CategoryRepository;

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
    void testShow() {
        // 입력 데이터 준비
        Integer category_id = 1;
        // 예상하기
        Category expected = categoryRepository.findById(category_id).orElse(null);
        // 실제 수행
        Category category = categoryService.show(category_id);
        // 검증
        assertEquals(expected.toString(), category.toString());
    }

    @Test
    void testShowAll() {
        // 입력 데이터 준비
        Integer userNum = 1;
        // 예상하기
        Category a = new Category(1, 1, "aaaa");
        Category b = new Category(2, 1, "bbbb");
        Category c = new Category(3, 1, "cccc");
        Category d = new Category(4, 1, "dddd");
        List<Category> expected = Arrays.asList(a, b, c, d);
        // 실제 수행
        List<Category> category = categoryService.showAll(userNum);
        // 검증
        assertEquals(expected.toString(), category.toString());
    }

    @Test
    @Transactional
    void testCategoryCreate() {
        // 입력 데이터 준비
        Integer user_num = 1;
        String category_name = "테스트";
        // 실제 수행
        Category category = categoryService.Create(new Category(user_num, category_name));
        // 예상하기
        Category expected = new Category(1, user_num, category_name);
        // 검증
        assertEquals(expected.toString(), category.toString());
    }

    @Test
    @Transactional
    void testCategoryUpdtae() {
        // 입력 데이터 준비
        Integer user_num = 1;
        String category_name = "테스트";
        // 실제 수행
        Category category = categoryService.Updtae(1, new Category(1, user_num, category_name));
        // 예상하기
        Category expected = new Category(1, user_num, category_name);
        // 검증
        assertEquals(expected.toString(), category.toString());
    }

    @Test
    @Transactional
    void testCategoryDelete() {
        // 입력 데이터 준비
        Integer category_id = 1;
        // 예상하기
        Category expected = categoryRepository.findById(category_id).orElse(null);
        // 실제 수행
        Category category = categoryService.Delete(category_id);
        // 검증
        assertEquals(expected.toString(), category.toString());
    }
}
