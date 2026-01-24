package com.example.fizz_buzz_combo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlayLog extends BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int generatedNumber;
    private int score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User user;

    @OneToMany(mappedBy = "playLog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LogRule> logRules = new ArrayList<>();

    public static PlayLog create(int generatedValue, int score, User user,List<GameRule> rules) {
        PlayLog playLog = new PlayLog();
        playLog.generatedNumber = generatedValue;
        playLog.score = score;
        playLog.user = user;
        
        rules.forEach(rule->playLog.addLogRule(rule));
        return playLog;
    }

    private void addLogRule(GameRule gameRule) {
        LogRule logRule = LogRule.create(this, gameRule);
        logRules.add(logRule);
    }
}
