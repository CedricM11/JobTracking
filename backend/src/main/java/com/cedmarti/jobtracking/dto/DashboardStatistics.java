package com.cedmarti.jobtracking.dto;

public class DashboardStatistics {

	private Long sent = 0L;
	private Long pending = 0L;
	private Long interviews = 0L;
	private Long positive = 0L;
	private Long rejected = 0L;

	public Long getSent() {
		return sent;
	}

	public Long getPending() {
		return pending;
	}

	public Long getInterviews() {
		return interviews;
	}

	public Long getPositive() {
		return positive;
	}

	public Long getRejected() {
		return rejected;
	}

	public void setSent(Long sent) {
		this.sent = sent;
	}

	public void setPending(Long pending) {
		this.pending = pending;
	}

	public void setInterviews(Long interviews) {
		this.interviews = interviews;
	}

	public void setPositive(Long positive) {
		this.positive = positive;
	}

	public void setRejected(Long rejected) {
		this.rejected = rejected;
	}
}
