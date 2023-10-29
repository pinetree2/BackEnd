package com.mango.repository;

import com.mango.entity.RestaurantKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantKeywordRepository extends JpaRepository<RestaurantKeyword,Long> {
}
