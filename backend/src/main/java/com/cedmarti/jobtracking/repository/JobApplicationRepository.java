package com.cedmarti.jobtracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cedmarti.jobtracking.model.JobApplication;
import com.cedmarti.jobtracking.repository.projections.StatusCountProjection;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

	@Query("""
		SELECT j.status as status, COUNT(j) as count
		FROM JobApplication j
		GROUP BY j.status
	""")
	List<StatusCountProjection> countApplicationByStatus();

}
