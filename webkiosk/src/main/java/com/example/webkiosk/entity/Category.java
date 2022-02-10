//강경민
package com.example.webkiosk.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userNum")
	private User userNum;

	@Column(length = 30)
	private String categoryName;

	@OneToMany(mappedBy = "categoryId")
	private List<Product> products = new ArrayList<>();

}
