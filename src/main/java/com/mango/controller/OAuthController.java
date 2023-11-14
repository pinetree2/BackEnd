package com.mango.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URL;

@RestController
@CrossOrigin("http://34.83.15.61:3000")
@RequiredArgsConstructor
@Tag(name = "OAuth", description = "OAuth 관련 API")
@RequestMapping("/auth/kakao")
public class OAuthController {
    @Operation(summary = "카카오 로그인창으로 이동")
    @GetMapping("/login")
    public ResponseEntity<?> authorize() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=1faaacda5628317938fb787d27311f89&redirect_uri=http://localhost:8080/auth/kakao/callback"));
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }


}
