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

}
