package com.example.fizz_buzz_combo.repository;


import org.springframework.data.repository.Repository;

import com.example.fizz_buzz_combo.entity.GameRule;

import java.util.List;
import java.util.Optional;


public interface GameRuleQueryRepository extends Repository<GameRule,String>{
    Optional<GameRule> findById(String id);

    List<GameRule> findAll();

    List<GameRule> findAllByIdIn(List<String> ids);
}
