package com.example.webkiosk.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import com.example.webkiosk.entity.Category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    // @Test
    // void testFindByUserId() {
    // /* Case 1: 1번의 모든 카테고리 조회 */
    // {
    // // 입력 데이터 준비
    // int user_num = 1;
    // // 실제 수행
    // List<Category> categories = categoryRepository.findByUserId(user_num);
    // // 예상하기
    // Category a = new Category(1, 1L, "aaaa");
    // Category b = new Category(2, 1L, "bbbb");
    // Category c = new Category(3, 1L, "cccc");
    // Category d = new Category(4, 1L, "dddd");
    // List<Category> expected = Arrays.asList(a, b, c, d);
    // // 검증
    // assertEquals(expected.toString(), categories.toString());
    // }
    // }
}
