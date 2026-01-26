package com.example.fizz_buzz_combo.controller.dto;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(
    String errorCode,
    String message,
    LocalDateTime timestamp,
    Map<String,String> details
) {
    
}
