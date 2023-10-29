package com.mango.repository;

import com.mango.entity.Keywords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordsRepository extends JpaRepository<Keywords,Long> {
}
