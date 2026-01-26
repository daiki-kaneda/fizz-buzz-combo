package com.example.fizz_buzz_combo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.Repository;

import com.example.fizz_buzz_combo.entity.PlayLog;

public interface PlayLogQueryRepository extends Repository<PlayLog,Long>{
    @EntityGraph(attributePaths = {"user", "logRules.gameRule"})
    List<PlayLog> findTop5ByOrderByScoreDesc();

    @EntityGraph(attributePaths = {"user", "logRules.gameRule"})
    List<PlayLog> findTop5ByUserUidOrderByScoreDesc(String uid);
}
