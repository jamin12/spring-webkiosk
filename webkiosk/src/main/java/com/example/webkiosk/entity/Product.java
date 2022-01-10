//강경민
package com.example.webkiosk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer userNum;

    @Column
    private Integer categoryNum;

    @Column
    private String productName;

    @Column
    private Integer productPrice;

    public Product(Integer userNum, Integer categoryNum, String productName, Integer productPrice) {
        this.userNum = userNum;
        this.categoryNum = categoryNum;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public void patch(Product product) {
        if (product.userNum != null) {
            this.userNum = product.userNum;
        }
        if (product.categoryNum != null) {
            this.categoryNum = product.categoryNum;
        }
        if (product.productName != null) {
            this.productName = product.productName;
        }
        if (product.productPrice != null) {
            this.productPrice = product.productPrice;
        }
    }
}
