package com.example.webkiosk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_num;

    @Column
    private String user_id;
    @Column
    private String user_pw;

    public Users(String user_id, String user_pw) {
        this.user_num = null;
        this.user_id = user_id;
        this.user_pw = user_pw;
    }

}
