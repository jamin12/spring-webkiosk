package com.example.webkiosk.service;

import com.example.webkiosk.entity.Category;
import com.example.webkiosk.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    // 카테고리 생성
    public Category categoryCreate(Category newCategory) {
        Category success = categoryRepository.save(newCategory);
        log.info("생성이 완료 되었습니다." + success.toString());
        return success;
    }

    // 카테고리 수정
    public Category categoryUpdtae(Integer id, Category upCategory) {
        Category target = categoryRepository.findById(id).orElse(null);

        if (target == null || id != upCategory.getCategory_id()) {
            log.info("잘못된 요청 입니다.", id, upCategory.toString());
            return null;
        }
        target.patch(upCategory);
        Category successUpCategory = categoryRepository.save(target);
        log.info("수정이 완료 되었습니다.");
        return successUpCategory;
    }

    // 카테고리 삭제
    public Category categoryDelete(Integer id) {
        Category target = categoryRepository.findById(id).orElse(null);
        if (target == null) {
            log.info("지울 수 있는 대상이 없습니다.");
            return null;
        }
        categoryRepository.delete(target);
        log.info("삭제가 완료 되었습니다.");
        return target;
    }

}
