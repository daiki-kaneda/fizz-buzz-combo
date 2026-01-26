package com.example.fizz_buzz_combo.service.rules;

import java.util.List;

import com.example.fizz_buzz_combo.config.properties.GameProperties;
import com.example.fizz_buzz_combo.config.properties.GameProperties.RuleConfig;

public abstract class AbstractGameRule implements GameRule {
    protected final GameProperties properties;

    protected AbstractGameRule(GameProperties properties) {
        this.properties = properties;
    }

    protected RuleConfig getConfig() {
        return properties.getConfig(getId());
    }

    @Override
    public String getName() {
        return getConfig().getName();
    }

    @Override
    public String getRarity() {
        return getConfig().getRarity();
    }

    @Override
    public List<String> getTags() {
        return getConfig().getTags();
    }

}
