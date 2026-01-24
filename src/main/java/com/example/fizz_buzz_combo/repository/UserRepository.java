package com.example.fizz_buzz_combo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fizz_buzz_combo.entity.User;

public interface UserRepository extends JpaRepository<User,String>{

}
