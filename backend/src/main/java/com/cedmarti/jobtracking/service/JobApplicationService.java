package com.cedmarti.jobtracking.service;

import java.util.List;

import com.cedmarti.jobtracking.model.JobApplication;

public interface JobApplicationService {
	List<JobApplication> getAllApplications();
	JobApplication getApplicationById(long id);
	JobApplication createApplication(JobApplication application);
	JobApplication updateApplication(Long id, JobApplication application);
	void deleteApplication(Long id);
}
