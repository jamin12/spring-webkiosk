
package com.example.webkiosk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webkiosk.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserId(String userId);
}