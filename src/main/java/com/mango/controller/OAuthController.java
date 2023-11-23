package com.mango.controller;

import com.mango.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

//import lombok.Value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin("http://34.83.15.61:3000")
@RequiredArgsConstructor
@Tag(name = "OAuth", description = "OAuth 관련 API")
@RequestMapping("/auth")
public class OAuthController {
    private final WebClient webClient;
    private final UserService userService;

    @Value("${spring.auth.clientId}")
    private String clientId;

    @Operation(summary = "카카오 로그인창으로 redirect")
    @GetMapping("/kakao/login")
    public ResponseEntity<?> authorize() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create(String.format("https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=%s&redirect_uri=http://localhost:8080/auth/kakao/callback", clientId)));
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    @Operation(summary = "카카오 로그인 callback url")
    @GetMapping(("/kakao/callback"))
    public ResponseEntity<?> callback(@RequestParam String code) {
        Map<String,String> ret = webClient.post()
                .uri("https://kauth.kakao.com/oauth/token")
                .header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
                .header("")
                .bodyValue(String.format("grant_type=authorization_code&client_id=%s&redirect_uri=http://localhost:8080/auth/kakao/callback&code=" + code, clientId))
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        String accessToken = ret.get("access_token");

        Map<String, ?> userInfo = webClient.get()
                .uri("https://kapi.kakao.com/v2/user/me")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        System.out.println(userInfo);
        String id = userInfo.get("id").toString();
//        String name = ((Map<String, String>)userInfo.get("profile")).get("nickname");
//        String profile = ((Map<String, String>)userInfo.get("profile")).get("profile_image_url");

        System.out.println("id : " + id);
//        System.out.println("name : " + name);
//        System.out.println("profile : " + profile);
        String token = userService.serviceLogin(id);
        return ResponseEntity.ok(token);
    }



}
