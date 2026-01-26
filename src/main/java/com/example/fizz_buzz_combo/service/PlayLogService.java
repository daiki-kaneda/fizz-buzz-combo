package com.example.fizz_buzz_combo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fizz_buzz_combo.controller.dto.GameResultDTO;
import com.example.fizz_buzz_combo.repository.PlayLogQueryRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlayLogService {
    private final PlayLogQueryRepository plRepository;

    public List<GameResultDTO> getTop5PlayLog() {
        return plRepository.findTop5ByOrderByScoreDesc()
                .stream()
                .map(pl -> GameResultDTO.from(pl))
                .toList();
    }

    public List<GameResultDTO> getTop5PlayLogBy(String uid) {
        return plRepository.findTop5ByUserUidOrderByScoreDesc(uid)
                .stream()
                .map(pl -> GameResultDTO.from(pl))
                .toList();
    }
}
