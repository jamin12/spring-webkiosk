package com.example.webkiosk.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

	private String userBirthday;

	@Column(length = 50)
	private String userEmail;

	@Column(length=30)
	private String userRole;
}