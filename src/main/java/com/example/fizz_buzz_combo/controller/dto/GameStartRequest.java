package com.example.fizz_buzz_combo.controller.dto;

import java.util.List;

import jakarta.validation.constraints.Size;

public record GameStartRequest(
    @Size(min = 1, max = 3, message = "ルールは1つから3つまで選んでください。")
    List<String> ruleIds
) {
    
}
