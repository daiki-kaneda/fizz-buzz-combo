package com.example.fizz_buzz_combo.service.rules;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.fizz_buzz_combo.config.properties.GameProperties;

@Component
public class FizzRule extends AbstractGameRule {

    public FizzRule(GameProperties properties) {
        super(properties);
    }

    @Override
    public String getId() {
        return "fizz";
    }

    @Override
    public int getScore(int number, List<GameRule> rules) {
        return properties.getConfig(getId()).getScore();
    }

    @Override
    public Integer getMultiple() {
        return properties.getConfig(getId()).getMultiple();
    }

    @Override
    public boolean shouldApply(int number) {
        return (number % properties.getConfig(getId()).getMultiple()) == 0;
    }
}
