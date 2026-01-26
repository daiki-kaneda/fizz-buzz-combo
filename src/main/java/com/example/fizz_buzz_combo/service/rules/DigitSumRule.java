package com.example.fizz_buzz_combo.service.rules;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.fizz_buzz_combo.config.properties.GameProperties;
import com.example.fizz_buzz_combo.service.GameRule;

@Component
public class DigitSumRule extends AbstractGameRule {
    public DigitSumRule(GameProperties properties){
        super(properties);
    }

    @Override
    public String getId() {
        return "digit-sum";
    }


    @Override
    public double getMultiplier(int number, List<GameRule> rules) {
        int digitSum = getDigitSum(number);
        double m = 1.0;
        for (GameRule rule : rules) {
            if (rule.getMultiple() != null && (digitSum % rule.getMultiple()) == 0) {
                m *= properties.getConfig(getId()).getMultiplier();
            }
        }
        return m;
    }

    private int getDigitSum(int number) {
        int sum = 0;
        int n = Math.abs(number);
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    @Override
    public boolean shouldApply(int number) {
        return true;
    }
}
