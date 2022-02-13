package com.example.webkiosk.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userNum;

	@Column(length = 20)
	private String userId;

	@Column(length = 64)
	private String userPassword;

	@Column(length = 10)
	private String userName;

	@Column(length = 20)
	private String userCompany;

	@Column(length = 11, name = "user_phone_number")
	private String userPhoneNumber;

	@Column(length = 11, nullable = true)
	private String userDiallingCode;

	@Column(length = 50)
	private String userEmail;
}