package com.cedmarti.jobtracking.repository.projections;

import com.cedmarti.jobtracking.model.enums.ApplicationStatus;

public interface StatusCountProjection {
	ApplicationStatus getStatus();
	Long getCount();
}
