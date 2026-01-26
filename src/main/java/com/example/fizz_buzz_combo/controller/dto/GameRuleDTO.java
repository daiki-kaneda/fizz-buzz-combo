package com.example.fizz_buzz_combo.controller.dto;

import java.util.List;

import com.example.fizz_buzz_combo.config.properties.GameProperties;
import com.example.fizz_buzz_combo.config.properties.GameProperties.RuleConfig;
import com.example.fizz_buzz_combo.entity.GameRule;

public record GameRuleDTO(
    String id,
    String name,
    String description,
    String rarity,
    List<String> tags,
    int score,
    Integer multiple,
    double multiplier
) {
    public static GameRuleDTO from(GameRule rule,GameProperties properties){
        RuleConfig ruleConfig = properties.getConfig(rule.getId());
        return new GameRuleDTO(
            rule.getId(), 
            ruleConfig.getName(), 
            rule.getDescription(), 
            ruleConfig.getRarity(), 
            ruleConfig.getTags(), 
            ruleConfig.getScore()            , 
            ruleConfig.getMultiple(), 
            ruleConfig.getMultiplier());
    }
}