package com.mango.controller;

import com.mango.dto.ReviewDto;
import com.mango.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
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

    private final ReviewService reviewService;
    @PostMapping("/review")
    @Operation(summary = "리뷰 등록")
    public ResponseEntity enrollReview(@PathVariable Long restaurantId,@RequestBody ReviewDto reviewDto){

        return reviewService.enrollReview(restaurantId,reviewDto);
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
