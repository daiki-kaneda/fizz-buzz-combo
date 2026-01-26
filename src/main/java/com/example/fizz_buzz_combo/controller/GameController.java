package com.example.fizz_buzz_combo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fizz_buzz_combo.controller.dto.GameResultDTO;
import com.example.fizz_buzz_combo.controller.dto.GameRuleDTO;
import com.example.fizz_buzz_combo.controller.dto.GameStartRequest;
import com.example.fizz_buzz_combo.service.GameRuleService;
import com.example.fizz_buzz_combo.service.GameService;
import com.example.fizz_buzz_combo.service.PlayLogService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GameController {
    private final GameRuleService gameRuleService;
    private final PlayLogService playLogService;
    private final GameService gameService;

    // ゲームルールのデータを取得
    @GetMapping("/rules")
    public ResponseEntity<List<GameRuleDTO>> getRules() {
        return ResponseEntity.ok(gameRuleService.getAllGameRules());
    }

    // ゲームスタート
    @PostMapping("/game/start")
    public ResponseEntity<GameResultDTO> start(
            @AuthenticationPrincipal Jwt jwt,
           @Valid @RequestBody GameStartRequest request) {
        GameResultDTO result = gameService.start(jwt, request.ruleIds());

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // ランキングを取得
    @GetMapping("/rankings")
    public ResponseEntity<List<GameResultDTO>> getRanking() {
        return ResponseEntity.ok(
                playLogService.getTop5PlayLog());
    }

    @GetMapping("/my-rankings")
    public ResponseEntity<List<GameResultDTO>> getMyRanking(
            @AuthenticationPrincipal Jwt jwt) {
        String uid = jwt.getSubject();
        return ResponseEntity.ok(
                playLogService.getTop5PlayLogBy(uid));
    }
}
