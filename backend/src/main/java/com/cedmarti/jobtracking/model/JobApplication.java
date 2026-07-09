package com.cedmarti.jobtracking.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cedmarti.jobtracking.model.enums.ApplicationSource;
import com.cedmarti.jobtracking.model.enums.ApplicationStatus;
import com.cedmarti.jobtracking.model.enums.ContractType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "job_applications")
public class JobApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "company_name", nullable = false)
	private String companyName;

	@NotBlank
	@Column(name = "job_title", nullable = false)
	private String jobTitle;

	private String industry;
	private String location;

	@Enumerated(EnumType.STRING)
	@Column(name = "contact_type")
	private ContractType contractType;

	@NotNull
	@Column(name = "application_date", nullable = false)
	private LocalDate applicationDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "application_source")
	private ApplicationSource applicationSource;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ApplicationStatus status;

	@Column(name = "next_action_date")
	private LocalDate nextActionDate;

	@Column(name = "contact_name")
	private String contactName;

	@Email
	@Column(name = "contact_mail")
	private String contactMail;

	@Column(name = "bob_offer_url", length = 2048)
	private String jobOfferUrl;

	@Size(max = 2000)
	@Column(length = 2000)
	private String notes;

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	@PrePersist
	public void prePersist() {
		LocalDateTime now = LocalDateTime.now();
		this.createdAt = now;
		this.updatedAt = now;
	}

	@PreUpdate
	public void preUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

	// GETTER
	public Long getId() {
		return id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getIndustry() {
		return industry;
	}

	public String getLocation() {
		return location;
	}

	public ContractType getContractType() {
		return contractType;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public ApplicationSource getApplicationSource() {
		return applicationSource;
	}

	public ApplicationStatus getStatus() {
		return status;
	}

	public LocalDate getNextActionDate() {
		return nextActionDate;
	}

	public String getContactName() {
		return contactName;
	}

	public String getContactMail() {
		return contactMail;
	}

	public String getJobOfferUrl() {
		return jobOfferUrl;
	}

	public String getNotes() {
		return notes;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	// SETTER
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public void setApplicationSource(ApplicationSource applicationSource) {
		this.applicationSource = applicationSource;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

	public void setNextActionDate(LocalDate nextActionDate) {
		this.nextActionDate = nextActionDate;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public void setContactMail(String contactMail) {
		this.contactMail = contactMail;
	}

	public void setJobOfferUrl(String jobOfferUrl) {
		this.jobOfferUrl = jobOfferUrl;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}



/*
JobApplication

id
companyName -> non null
jobTitle -> non null
industry -> secteur activite
location -> adresse postal / ville
contractType -> Enum (cdi, cdd, aternance stage, freelance)
applicationDate -> non null
applicationSource -> Enum (EMAIL, LINKEDIN, INDEED, WELCOME_TO_THE_JUNGLE, COMPANY_WEBSITE, PHONE, IN_PERSON, OTHER)
status -> Enum (BROUILLON, A_ENVOYER, ENVOYEE, A_RELANCER, ENTRETIEN, OFFRE, REFUSEE, ABANDONNEE)
nextActionDate
contactName
contactEmail
jobOfferUrl
notes -> len caractere limit
createdAt -> non null
updatedAt -> non null
*/