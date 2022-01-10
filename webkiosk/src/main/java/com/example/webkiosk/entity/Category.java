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
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;

	@Column
	private Integer userNum;

	@Column
	private String category_name;

	public Category(Integer userNum, String category_name) {
		this.userNum = userNum;
		this.category_name = category_name;
	}

	public void patch(Category category) {
		if (category.userNum != null) {
			this.userNum = category.userNum;
		}
		if (category.category_name != null) {
			this.category_name = category.category_name;
		}
	}

}
