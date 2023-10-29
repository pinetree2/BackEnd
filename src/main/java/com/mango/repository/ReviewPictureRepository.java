package com.mango.repository;

import com.mango.entity.ReviewPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReviewPictureRepository extends JpaRepository<ReviewPicture,Long>{
}
