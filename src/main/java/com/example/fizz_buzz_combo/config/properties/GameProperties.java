package com.example.fizz_buzz_combo.config.properties;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "game")
@Data
public class GameProperties {
    // キーはルールのidに対応
    private Map<String, RuleConfig> rules;

    @Data
    public static class RuleConfig {
        private String name;
        private String rarity;
        private List<String> tags;
        private int score = 0;
        private Integer multiple;
        private double multiplier = 1.0;
    }
}
