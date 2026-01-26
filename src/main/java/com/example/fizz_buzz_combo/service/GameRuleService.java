package com.example.fizz_buzz_combo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fizz_buzz_combo.config.properties.GameProperties;
import com.example.fizz_buzz_combo.controller.dto.GameRuleDTO;
import com.example.fizz_buzz_combo.repository.GameRuleQueryRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GameRuleService {
    private final GameRuleQueryRepository gameRuleQueryRepository;
    private final GameProperties gameProperties;

    public List<GameRuleDTO> getAllGameRules() {
        return gameRuleQueryRepository.findAll()
                .stream()
                .map(
                        rule -> GameRuleDTO.from(rule, gameProperties))
                .toList();
    }
}
