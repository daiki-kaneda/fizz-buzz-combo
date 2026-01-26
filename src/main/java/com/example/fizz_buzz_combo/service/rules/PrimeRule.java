package com.example.fizz_buzz_combo.service.rules;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.example.fizz_buzz_combo.config.properties.GameProperties;
import com.example.fizz_buzz_combo.service.GameRule;

@Component
public class PrimeRule extends AbstractGameRule{
    public PrimeRule(GameProperties properties){
        super(properties);
    }

    @Override
    public String getId() {
        return "prime";
    }

    @Override
    public int getScore(int number, List<GameRule> rules) {
        return properties.getConfig(getId()).getScore();
    }

    @Override
    public boolean shouldApply(int number) {
        return IntStream
        .rangeClosed(1,number)
        .filter(
            n->(number % n) == 0
        )
        .count()==2;

    }
}
