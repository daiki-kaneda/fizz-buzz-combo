package com.example.fizz_buzz_combo.service.gamerule.rules;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.fizz_buzz_combo.config.properties.GameProperties;
import com.example.fizz_buzz_combo.service.gamerule.AbstractGameRule;
import com.example.fizz_buzz_combo.service.gamerule.GameRule;

@Component
public class BuzzRule extends AbstractGameRule{
    public BuzzRule(GameProperties properties){
        super(properties);
    }

    @Override
    public String getId() {
        return "buzz";
    }

    @Override
    public int getScore(int number, List<GameRule> rules) {
        return properties.getConfig(getId()).getScore();
    }

    @Override
    public Integer getMultiple() {
        return  properties.getConfig(getId()).getMultiple();
    }

    @Override
    public boolean shouldApply(int number) {
        return (number %  properties.getConfig(getId()).getMultiple()) == 0;
    }
}
