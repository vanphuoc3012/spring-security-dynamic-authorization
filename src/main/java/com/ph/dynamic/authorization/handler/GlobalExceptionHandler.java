package com.ph.dynamic.authorization.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<Map<String, String>> handleException(Exception e) {
//        Map<String, String> stringMap = new HashMap<>();
//        stringMap.put("Error", "Unexpected error");
//        return new ResponseEntity<>(stringMap, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
