package com.example.webkiosk.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import com.example.webkiosk.entity.Product;
import com.example.webkiosk.repository.ProductRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void productOfCategory() {
        // 입력 데이터 준비
        Integer userNum = 1;
        Integer categoryNum = 1;
        // 실제 수행
        List<Product> category = productService.productOfCategory(categoryNum, userNum);
        // 예상하기
        Product a = new Product(1, 1, 1, "qewr", 1111);
        Product b = new Product(2, 1, 1, "tyui", 2222);
        List<Product> expected = Arrays.asList(a, b);
        // 검증
        assertEquals(expected.toString(), category.toString());
    }

    @Test
    @Transactional
    void testCreate() {
        // 입력 데이터 준비
        Integer userNum = 1;
        Integer categoryNum = 1;
        String productName = "테스트";
        // 실제 수행
        Product category = productService.Create(new Product(userNum, categoryNum, productName, 1111));
        // 예상하기
        Product expected = new Product(1, userNum, categoryNum, productName, 1111);
        // 검증
        assertEquals(expected.toString(), category.toString());
    }

    @Test
    @Transactional
    void testUpdtae() {
        // 입력 데이터 준비
        Integer userNum = 1;
        Integer categoryNum = 1;
        String productName = "테스트";
        // 실제 수행
        Product category = productService.Updtae(2, new Product(2, userNum, categoryNum, productName, 1111));
        // 예상하기
        Product expected = new Product(2, userNum, categoryNum, productName, 1111);
        // 검증
        assertEquals(expected.toString(), category.toString());
    }

    @Test
    @Transactional
    void testDelete() {
        // 입력 데이터 준비
        Integer category_id = 1;
        // 예상하기
        Product expected = productRepository.findById(category_id).orElse(null);
        // 실제 수행
        Product category = productService.Delete(category_id);
        // 검증
        assertEquals(expected.toString(), category.toString());
    }
}
