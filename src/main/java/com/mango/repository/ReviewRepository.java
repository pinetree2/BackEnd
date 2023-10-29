package com.mango.repository;

import com.mango.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
