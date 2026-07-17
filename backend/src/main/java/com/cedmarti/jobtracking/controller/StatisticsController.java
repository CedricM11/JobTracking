package com.cedmarti.jobtracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cedmarti.jobtracking.dto.DashboardStatistics;
import com.cedmarti.jobtracking.service.DashboardStatisticsService;

@RestController
@RequestMapping("/api/v1/statistics")
public class StatisticsController {

	@Autowired
	private DashboardStatisticsService dashboardStats;

	@GetMapping("/preview")
	public DashboardStatistics getStatisticsPreview() {
		return dashboardStats.getStatisticsPreview();
	}
}
