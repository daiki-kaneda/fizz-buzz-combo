package com.example.fizz_buzz_combo.service;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fizz_buzz_combo.entity.User;
import com.example.fizz_buzz_combo.repository.UserQueryRepository;
import com.example.fizz_buzz_combo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserQueryRepository userQueryRepository;
    private final UserRepository userRepository;

    @Transactional
    User getOrCreateUser(Jwt jwt) {
        String uid = jwt.getSubject();

        return userQueryRepository.findById(uid)
                .orElseGet(
                        () -> {
                            String maybeName = jwt.getClaimAsString("name");
                            String maybeEmail = jwt.getClaimAsString("email");
                            String name = maybeName != null ? maybeName : "Unknown User";
                            User newUser = User.create(uid, name, maybeEmail);
                            userRepository.save(newUser);
                            return newUser;
                        });
    }
}
