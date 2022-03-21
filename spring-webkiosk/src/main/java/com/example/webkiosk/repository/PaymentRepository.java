package com.example.webkiosk.repository;

import java.util.List;

import com.example.webkiosk.entity.PaymentDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDetail, Long> {
    // 판매 기록
    public List<PaymentDetail> findByUserNum(Long userNum);

    // 날짜별 기록
    @Query(value = "SELECT * from payment_detail pd where user_num = :userNum and DATE(payment_datetime) = DATE(:date);", nativeQuery = true)
    public List<PaymentDetail> findByDate(@Param("userNum") Long userNum,
            @Param("date") String date);

    // 월별 기록
    @Query(value = "SELECT * from payment_detail pd where user_num = :userNum and MONTH(payment_datetime) = MONTH(:date);", nativeQuery = true)
    public List<PaymentDetail> findByMonth(@Param("userNum") Long userNum, @Param("date") String date);
}
