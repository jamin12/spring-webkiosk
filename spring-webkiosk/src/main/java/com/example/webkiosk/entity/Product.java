//강경민
package com.example.webkiosk.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private Long categoryId;

    @Column(length = 30)
    private String productName;

    @Column
    private Integer productPrice;

    @Column(length = 255)
    private String productInfo;

    @Column(length = 50)
    private String productImage;
}
