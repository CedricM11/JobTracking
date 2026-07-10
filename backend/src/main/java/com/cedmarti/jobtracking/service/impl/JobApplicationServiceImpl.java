package com.cedmarti.jobtracking.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedmarti.jobtracking.model.JobApplication;
import com.cedmarti.jobtracking.repository.JobApplicationRepository;
import com.cedmarti.jobtracking.service.JobApplicationService;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

	@Autowired
	private JobApplicationRepository repository;

	@Override
	public List<JobApplication> getAllApplications() {
		return repository.findAll();
	}

	@Override
	public JobApplication getApplicationById(long id) {
		return repository.findById(id)
						.orElseThrow(() -> new RuntimeException("Application not found"));
	}

	@Override
	public JobApplication createApplication(JobApplication application) {
		return repository.save(application);
	}

	@Override
	public JobApplication updateApplication(Long id, JobApplication application) {

		JobApplication existing = getApplicationById(id);

		existing.setCompanyName(application.getCompanyName());
		existing.setJobTitle(application.getJobTitle());
		existing.setIndustry(application.getIndustry());
		existing.setStatus(application.getStatus());
		existing.setLocation(application.getLocation());
		existing.setContractType(application.getContractType());
		existing.setApplicationDate(application.getApplicationDate());
		existing.setApplicationSource(application.getApplicationSource());
		existing.setNextActionDate(application.getNextActionDate());
		existing.setContactName(application.getContactName());
		existing.setContactMail(application.getContactMail());
		existing.setJobOfferUrl(application.getJobOfferUrl());
		existing.setNotes(application.getNotes());
		existing.setUpdatedAt(LocalDateTime.now());

		return repository.save(existing);
	}

	@Override
	public void deleteApplication(Long id) {
		repository.deleteById(id);
	}
}
