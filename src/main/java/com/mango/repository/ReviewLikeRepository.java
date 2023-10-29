package com.mango.repository;

import com.mango.entity.ReviewLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReviewLikeRepository extends JpaRepository<ReviewLike,Long> {
}
