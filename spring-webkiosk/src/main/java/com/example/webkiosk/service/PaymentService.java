package com.example.webkiosk.service;

import java.util.List;

import com.example.webkiosk.entity.PaymentDetail;
import com.example.webkiosk.repository.PaymentRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    // 판매 기록
    public List<PaymentDetail> getPaymentDetails(Long userNum) {
        List<PaymentDetail> payList = paymentRepository.findByUserNum(userNum);
        return payList;
    }

    // 전체 금액
    public void getTotalPayment(Long userNum) {
        int total = 0;
        List<PaymentDetail> plist = paymentRepository.findByUserNum(userNum);
        for (PaymentDetail list : plist) {
            System.out.println(list.getPaymentProductPrice());
            total += list.getPaymentProductPrice();
            System.out.println(total);
        }
        System.out.println(total);
    }
}
