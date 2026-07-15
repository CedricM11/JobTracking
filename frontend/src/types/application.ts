export type ApplicationStatus =
	| 'BROUILLON'
	| 'A_ENVOYER'
	| 'ENVOYEE'
	| 'A_RELANCER'
	| 'ENTRETIEN'
	| 'OFFRE'
	| 'REFUSEE'
	| 'ABANDONNEE'

export type ApplicationSource =
	| 'EMAIL'
	| 'LINKEDIN'
	| 'INDEED'
	| 'WELCOME_TO_THE_JUNGLE'
	| 'COMPANY_WEBSITE'
	| 'PHONE'
	| 'IN_PERSON'
	| 'OTHER'

export type ContractType =
	| 'CDI'
	| 'CDD'
	| 'ALTERNANCE'
	| 'STAGE'
	| 'FREELANCE'

export type Application = {
	id: number
	applicationDate: string
	applicationSource: ApplicationSource
	companyName: string
	contactMail: string
	contactName: string
	contractType: ContractType
	createdAt: string
	industry: string
	jobOfferUrl: string
	jobTitle: string
	location: string
	nextActionDate: string
	notes: string
	status: ApplicationStatus
	updatedAt: string
}