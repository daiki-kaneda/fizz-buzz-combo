package com.example.fizz_buzz_combo.repository;

import org.springframework.data.repository.Repository;

import com.example.fizz_buzz_combo.entity.User;
import java.util.Optional;


public interface UserQueryRepository extends Repository<User,String>{
    Optional<User> findById(String id);
}
