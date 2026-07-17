package com.cedmarti.jobtracking.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cedmarti.jobtracking.dto.DashboardStatistics;
import com.cedmarti.jobtracking.model.enums.ApplicationStatus;
import com.cedmarti.jobtracking.repository.JobApplicationRepository;
import com.cedmarti.jobtracking.repository.projections.StatusCountProjection;
import com.cedmarti.jobtracking.service.DashboardStatisticsService;

@Service
public class DashboardStatisticsServiceImpl implements DashboardStatisticsService {

	@Autowired
	private JobApplicationRepository repository;

	@Override
	public DashboardStatistics getStatisticsPreview() {

		DashboardStatistics stats = new DashboardStatistics();
		List<StatusCountProjection> counts = repository.countApplicationByStatus();
		long sentCount = 0;
		
		for (StatusCountProjection row : counts) {
			ApplicationStatus status = row.getStatus();
			Long count = row.getCount();

			switch (status) {
				case ENVOYEE:
				case A_RELANCER:
				case ENTRETIEN:
				case OFFRE:
				case REFUSEE:
					sentCount += count;
					break;

				case BROUILLON:
				case A_ENVOYER:
				case ABANDONNEE:
					break;

				default:
					break;
			}

			switch (status) {
				case A_RELANCER:
					stats.setPending(count);
					break;

				case ENTRETIEN:
					stats.setInterviews(count);
					break;

				case OFFRE:
					stats.setPositive(count);
					break;

				case REFUSEE:
					stats.setRejected(count);
					break;

				default:
					break;
			}
		}
		stats.setSent(sentCount);
		return stats;
	}
}
