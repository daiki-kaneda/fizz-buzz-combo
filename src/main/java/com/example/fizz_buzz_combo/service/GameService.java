package com.example.fizz_buzz_combo.service;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import com.example.fizz_buzz_combo.controller.dto.GameResultDTO;
import com.example.fizz_buzz_combo.entity.PlayLog;
import com.example.fizz_buzz_combo.entity.User;
import com.example.fizz_buzz_combo.repository.GameRuleQueryRepository;
import com.example.fizz_buzz_combo.repository.PlayLogRepository;
import com.example.fizz_buzz_combo.service.rules.GameRule;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameService {
    private final UserService userService;
    private final GameRuleQueryRepository gameRuleQueryRepository;
    private final PlayLogRepository playLogRepository;
    private final List<GameRule> gameRules;

    public GameResultDTO start(Jwt jwt, List<String> ruleIds) {
        RandomGenerator random = RandomGenerator.getDefault();
        int generatedNumber = random.nextInt(1, 101);
        int score = (int) calculateScore(generatedNumber, ruleIds);

        List<com.example.fizz_buzz_combo.entity.GameRule> rules = gameRuleQueryRepository.findAllByIdIn(ruleIds);
        User user = userService.getOrCreateUser(jwt);
        PlayLog log = PlayLog.create(generatedNumber, score, user, rules);

        return GameResultDTO.from(
                playLogRepository.save(log));
    }

    private long calculateScore(int generatedNumber, List<String> ruleIds) {
        // 適用ルールを取得
        List<GameRule> appliedRules = gameRules
                .stream()
                .filter(rule -> ruleIds.contains(rule.getId()))
                .filter(rule -> rule.shouldApply(generatedNumber))
                .toList();
        // ベーススコアの計算
        int baseScore = appliedRules
                .stream()
                .collect(Collectors.summingInt(rule -> rule.getScore(generatedNumber, appliedRules)));
        // 倍率を計算(コンボなど)
        double multiplier = appliedRules
                .stream()
                .map(rule -> rule.getMultiplier(generatedNumber, appliedRules))
                .reduce(1.0, (a, b) -> a * b);
        // 浮動小数点数を整数に四捨五入
        return Math.round(baseScore * multiplier);
    }
}
