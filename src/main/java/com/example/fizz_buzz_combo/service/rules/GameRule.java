package com.example.fizz_buzz_combo.service.rules;

import java.util.List;

public interface GameRule {
    String getId();
    String getName();
    String getRarity(); // common,uncommon,rare
    List<String> getTags(); // tag: multiple,combo,special

    // 発動条件
    boolean shouldApply(int number);

    // 基本スコア
    default int getScore(int number,List<GameRule> rules){
        return 0;
    }

    // 倍数(倍数ルールの時のみ)
    default Integer getMultiple(){
        return null;
    }

    // 倍率（comboルールの時のみ)
    default double getMultiplier(int number,List<GameRule> rules){
        return 1.0;
    }
}
