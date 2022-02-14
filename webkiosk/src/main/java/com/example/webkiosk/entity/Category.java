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

	private Long userNum;

	@Column(length = 30)
	private String categoryName;

}
