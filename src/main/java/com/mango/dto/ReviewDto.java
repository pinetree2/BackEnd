package com.mango.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDto {
    private boolean score;
    private String reviewContents;
    private MultipartFile reviewPic;
}
