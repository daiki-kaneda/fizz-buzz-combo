package com.example.fizz_buzz_combo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LogRule extends BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "play_log_id")
    private PlayLog playLog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_rule_id")
    private GameRule gameRule;

    @Override
    public Long getId() {
        return id;
    }

    public static LogRule create(
            PlayLog playLog,
            GameRule gameRule) {
        LogRule logRule = new LogRule();
        logRule.playLog = playLog;
        logRule.gameRule = gameRule;
        return logRule;
    }
}
