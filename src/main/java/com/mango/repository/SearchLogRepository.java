package com.mango.repository;

import com.mango.entity.SearchLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SearchLogRepository extends JpaRepository<SearchLog,Long> {
}
