package com.ph.dynamic.authorization.controller;

import com.ph.dynamic.authorization.entities.UserEntity;
import com.ph.dynamic.authorization.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
