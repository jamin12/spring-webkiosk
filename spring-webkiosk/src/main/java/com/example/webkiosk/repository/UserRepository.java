
package com.example.webkiosk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.webkiosk.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(String userId);

    User getUserByUserId(String userId);
}