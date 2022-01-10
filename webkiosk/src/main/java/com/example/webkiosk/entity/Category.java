//강경민
package com.example.webkiosk.entity;

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

	private Integer userNum;

	private String categoryName;

	public Category(Integer userNum, String categoryName) {
		this.userNum = userNum;
		this.categoryName = categoryName;
	}

	public void patch(Category category) {
		if (category.userNum != null) {
			this.userNum = category.userNum;
		}
		if (category.categoryName != null) {
			this.categoryName = category.categoryName;
		}
	}

}
