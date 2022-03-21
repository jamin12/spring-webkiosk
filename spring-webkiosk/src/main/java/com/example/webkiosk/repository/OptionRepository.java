<<<<<<< HEAD
package com.example.webkiosk.repository;

import com.example.webkiosk.entity.Category;
import com.example.webkiosk.entity.Option;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
	List<Option> findByUserNum(Long userNum);

	@Query(value = "SELECT * FROM option o JOIN product_detail pd ON o.option_id = pd.option_id WHERE product_id = :productId AND user_num = :userNum", nativeQuery = true)
	List<Option> getOptionByProductIdAndUserNum(Long productId, Long userNum);
}
=======
package com.example.webkiosk.repository;

import com.example.webkiosk.entity.Category;
import com.example.webkiosk.entity.Option;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
	List<Option> findByUserNum(Long userNum);

	@Query(value = "SELECT * FROM option o JOIN product_detail pd ON o.option_id = pd.option_id WHERE product_id = :productId AND user_num = :userNum", nativeQuery = true)
	List<Option> getOptionByProductIdAndUserNum(Long productId, Long userNum);
}
>>>>>>> main
