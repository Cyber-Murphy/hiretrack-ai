package com.example.demo.repository;


import com.example.demo.entity.Job;
import com.example.demo.entity.JobStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository

public interface JobRepository extends JpaRepository<Job, UUID>{

    // fetches all the jobs for one user
    List<Job> findByUserId(UUID user_id);

    // Get jobs filtered by status — used in kanban board
    List<Job> findByUserAndStatus(UUID user_id ,JobStatus status);

    // Count jobs by status — used in dashboard stats
    long countByUserIdAndStatus(UUID user_id , JobStatus status);
}

