package com.example.webkiosk.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PaymentDetail {
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long paymentId;

    @Column(name = "user_num")
    Long userNum;
    @Column(name = "payment_product_id")
    Long paymentProductId;
    @Column(name = "payment_product_price")
    Integer paymentProductPrice;
    @Column(name = "payment_order_number")
    Long paymentOrderNumber;
    @Column(name = "payment_datetime")
    String paymentDatetime;
    @Column(name = "payment_option_flag")
    Integer paymentOptionFlag;
}
