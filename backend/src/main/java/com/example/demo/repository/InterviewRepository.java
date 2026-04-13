package com.example.demo.repository;

import com.example.demo.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface InterviewRepository extends JpaRepository<Interview,UUID> {

    // Get all interview rounds for one job — used in job detail page


    List<Interview> findByJobId(UUID jobId);
}