package com.example.webkiosk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_num", nullable = false, length = 11)
	
	private Integer usernum;
	
	@NotBlank(message = "아이디 입력은 필수 입니다.")
	@Column(name = "user_id", nullable = false, length = 50)
	private String userid;
	
	@NotBlank(message = "비밀번호 입력은 필수 입니다.")
	@Column(name = "user_pw", nullable = false, length = 255)
	private String userpw;
	
	@NotBlank(message = "이름 입력은 필수 입니다.")
	@Column(name = "user_name", nullable = false, length = 50)
	private String username;
	
	@NotBlank(message = "회사 입력은 필수 입니다.")
	@Column(name = "user_company", nullable = false, length = 50)
	private String usercompany;
	
	@NotBlank(message = "핸드폰번호 입력은 필수 입니다.")
	@Column(name = "mobile", nullable = false, length = 50)
	private String mobile;
	
	@NotBlank(message = "이메일 입력은 필수 입니다.")
	@Column(name = "email", nullable = false, length = 255)
	private String email;
}