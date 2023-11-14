package com.mango.service;

import com.mango.entity.User;
import com.mango.jwt.JwtTokenProvider;
import com.mango.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public void signUp(String email, String password, String nickname) {
        userRepository.findByEmail(email)
                .ifPresent(user -> {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "이미 존재하는 유저 이름입니다.");
                });
        User user = User.builder()
                .email(email)
                .nickname(nickname)
                .password(password)
                .build();
        userRepository.save(user);
    }

    public String login(String username, String password) {
        User user = userRepository.findByEmailAndPassword(username, password)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "존재하지 않는 유저입니다."));
        String token = jwtTokenProvider.createToken(user.getEmail());
        return token;
    }
}

