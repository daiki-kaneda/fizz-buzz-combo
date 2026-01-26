package com.example.fizz_buzz_combo.controller.dto;

import java.time.Instant;
import java.util.List;

import com.example.fizz_buzz_combo.entity.PlayLog;

public record GameResultDTO(
        String name,
        Instant playedAt,
        int generatedNumber,
        int score,
        List<String> ruleNames) {
    public static GameResultDTO from(PlayLog log) {
        return new GameResultDTO(
                log.getUser().getName() != null ? log.getUser().getName() : "匿名プレイヤー",
                log.getCreatedAt(),
                log.getGeneratedNumber(),
                log.getScore(),
                log.getLogRules()
                        .stream()
                        .map(lr -> lr.getGameRule().getName())
                        .toList());
    }
}
