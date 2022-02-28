package com.example.webkiosk.repository;

import java.util.List;

import com.example.webkiosk.entity.PaymentDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDetail, Long> {
    // 판매 기록
    public List<PaymentDetail> findByUserNum(Long userNum);
}
