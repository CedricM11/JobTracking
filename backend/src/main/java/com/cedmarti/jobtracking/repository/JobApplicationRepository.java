package com.cedmarti.jobtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cedmarti.jobtracking.model.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
}
