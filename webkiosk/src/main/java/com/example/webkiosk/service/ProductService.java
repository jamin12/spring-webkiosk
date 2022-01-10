//강경민
package com.example.webkiosk.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.webkiosk.entity.Product;
import com.example.webkiosk.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    // 회원의 한 카테고리 상품 가져오기
    public List<Product> productOfCategory(Integer categoryNum, Integer userNum) {
        return productRepository.findByCategoryNumAndUserNum(categoryNum, userNum);
    }

    // 상품 생성
    @Transactional
    public Product Create(Product newProduct) {
        Product success = productRepository.save(newProduct);
        log.info("생성이 완료 되었습니다." + success.toString());
        return success;
    }

    // 상품 수정
    @Transactional
    public Product Updtae(Integer id, Product upProduct) {
        Product target = productRepository.findById(id).orElse(null);

        if (target == null || id != upProduct.getId()) {
            log.info("잘못된 요청 입니다.", id, upProduct.toString());
            return null;
        }
        target.patch(upProduct);
        Product successUpCategory = productRepository.save(target);
        log.info("수정이 완료 되었습니다.");
        return successUpCategory;
    }

    // 상품 삭제
    @Transactional
    public Product Delete(Integer id) {
        Product target = productRepository.findById(id).orElse(null);
        if (target == null) {
            log.info("지울 수 있는 대상이 없습니다.");
            return null;
        }
        productRepository.delete(target);
        log.info("삭제가 완료 되었습니다.");
        return target;
    }
}
