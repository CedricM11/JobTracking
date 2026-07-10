package com.cedmarti.jobtracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cedmarti.jobtracking.model.JobApplication;
import com.cedmarti.jobtracking.service.JobApplicationService;

@RestController
@RequestMapping("/api/v1/applications")
public class JobApplicationController {

	@Autowired
	private JobApplicationService jobAppService;

	@GetMapping
	public List<JobApplication> getAllApplications() {
		return jobAppService.getAllApplications();
	}

	@GetMapping("/{id}")
	public JobApplication getApplicationById(@PathVariable Long id) {
		return jobAppService.getApplicationById(id);
	}

	@PostMapping
	public JobApplication createApplication(@RequestBody JobApplication application) {
		return jobAppService.createApplication(application);
	}

	@PutMapping("/{id}")
	public JobApplication updateApplication(@PathVariable Long id, @RequestBody JobApplication application) {
		return jobAppService.updateApplication(id, application);
	}

	@DeleteMapping("/{id}")
	public void deleteApplication(@PathVariable Long id) {
		jobAppService.deleteApplication(id);
	}
}
