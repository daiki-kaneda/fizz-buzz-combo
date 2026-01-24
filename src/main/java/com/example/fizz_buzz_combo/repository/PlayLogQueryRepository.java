package com.example.fizz_buzz_combo.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.fizz_buzz_combo.entity.PlayLog;

public interface PlayLogQueryRepository extends Repository<PlayLog,Long>{
    List<PlayLog> findTop5ByOrderByScoreDesc();

    List<PlayLog> findTop5ByUserUidOrderByScoreDesc(String uid);
}
