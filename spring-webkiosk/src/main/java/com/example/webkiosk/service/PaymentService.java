package com.example.webkiosk.service;

import java.util.Date;
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
    public int getSelectPaymentDetail(Long userNum, String date, String select) {
        int total = 0;
        List<PaymentDetail> plist = null;
        switch (select) {
            case "date":
                plist = paymentRepository.findByDate(userNum, date);
                break;
            case "month":
                plist = paymentRepository.findByMonth(userNum, date);
                break;
        }
        for (PaymentDetail list : plist) {
            total += list.getPaymentProductPrice();
            System.out.println(list.getPaymentDatetime());
        }

        return total;
    }
}
