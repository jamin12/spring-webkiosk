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
	private Integer category_id;

	@Column
	private Integer user_num;

	@Column
	private String category_name;

	public Category(Integer user_num, String category_name) {
		this.user_num = user_num;
		this.category_name = category_name;
	}

	public void patch(Category category) {
		if (category.user_num != null) {
			this.user_num = category.user_num;
		}
		if (category.category_name != null) {
			this.category_name = category.category_name;
		}
	}

}
