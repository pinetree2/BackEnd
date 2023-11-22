package com.mango.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://34.83.15.61:3000")
@RequiredArgsConstructor
@RequestMapping("/api/restaurants")
@Tag(name = "Review", description = "리뷰 관련 API")
public class ReviewController {

    @PostMapping("/review")
    public ResponseEntity enrollReview() {
        return null;
    }
    @GetMapping("/review")
    public ResponseEntity getReview() {
        return null;
    }
    @DeleteMapping("/review")
    public ResponseEntity deleteReview() {
        return null;
    }
}
