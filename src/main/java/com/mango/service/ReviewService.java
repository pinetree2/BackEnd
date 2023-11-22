package com.mango.service;

import com.google.api.services.storage.Storage;
import com.google.cloud.storage.BlobInfo;
import com.mango.dto.ReviewDto;
import com.mango.entity.Restaurant;
import com.mango.entity.Review;
import com.mango.entity.ReviewPicture;
import com.mango.repository.RestaurantRepository;
import com.mango.repository.ReviewPictureRepository;
import com.mango.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewPictureRepository reviewPictureRepository;
    private final RestaurantRepository restaurantRepository;
    private String baseurl = "https://storage.googleapis.com/durian-storage/";
    private final Storage storage;

    // 버킷이름 따로 properties에 저장했음
    @Value("${spring.cloud.gcp.storage.bucket}")
    private String bucketName;

    public ResponseEntity enrollReview(Long restaurantId ,ReviewDto reviewDto) {
        //restaurantId로 restaurant 찾기
        long reviewId = 0L;
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new IllegalArgumentException("해당 식당이 없습니다.")
        );
        String fileName = UUID.randomUUID().toString(); // 파일명 중복 방지
        String ext = file.getContentType();
        BlobInfo blobInfo = storage.create(
                BlobInfo.newBuilder(bucketName, fileName)
                        .setContentType(ext)
                        .build(),
                file.getInputStream()
        );
        Review review = Review.builder()
                .score(reviewDto.isScore())
                .restaurant(restaurant)
                .reviewContents(reviewDto.getReviewContents())
                .build();


        try {
            reviewId = reviewRepository.save(review).getId();

        } catch (Exception e) {
            throw new RuntimeException("리뷰 등록에 실패했습니다.");
        }

        Review reviewResult = reviewRepository.findById(reviewId).orElseThrow(
                () -> new IllegalArgumentException("해당 식당의 리뷰가 없습니다.")
        );

        ReviewPicture reviewPicture = ReviewPicture.builder()
                .reviewPicUrl(reviewDto.getReviewPic().getOriginalFilename())
                .review(reviewResult)
                .build();

        try {
            reviewPictureRepository.save(reviewPicture);
        } catch (Exception e) {
            throw new RuntimeException("리뷰 등록에 실패했습니다.");
        }

        return ResponseEntity.ok().body("리뷰 등록에 성공했습니다.");


    }
}
