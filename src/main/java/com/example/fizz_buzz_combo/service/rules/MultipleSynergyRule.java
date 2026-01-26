package com.example.fizz_buzz_combo.service.rules;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.fizz_buzz_combo.config.properties.GameProperties;

@Component
public class MultipleSynergyRule extends AbstractGameRule{
    public MultipleSynergyRule(GameProperties properties){
        super(properties);
    }

    @Override
    public String getId() {
        return "multiple-synergy";
    }

    @Override
    public double getMultiplier(int number, List<GameRule> rules) {
        long multipleRulesCount = rules.stream()
        .filter(rule->rule.getMultiple()!=null)
        .count();
        return multipleRulesCount >=2 ?  properties.getConfig(getId()).getMultiplier() : 1.0;
    }

    @Override
    public boolean shouldApply(int number) {
        return true;
    }
}
