package com.example.fizz_buzz_combo.controller.advice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.fizz_buzz_combo.controller.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException e) {
        Map<String, String> details = new HashMap<>();
        e.getBindingResult().getFieldErrors()
                .forEach(error -> details.put(error.getField(), error.getDefaultMessage()));

        ErrorResponse error = new ErrorResponse(
                "VALIDATION_ERROR",
                "入力内容に不備があります。",
                LocalDateTime.now(),
                details);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handleIllegalStateException(
            IllegalStateException e) {
        ErrorResponse error = new ErrorResponse(
                "SYSTEM_ERROR",
                e.getMessage(),
                LocalDateTime.now(),
                null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception e) {
        return ResponseEntity.status(
                HttpStatus.INTERNAL_SERVER_ERROR).body(
                        new ErrorResponse(
                                "UNKNOWN_ERROR",
                                "予期せぬエラーが発生しました." + e.getMessage(),
                                LocalDateTime.now(),
                                null));
    }
}