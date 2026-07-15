import type { Application } from "@/types/application";

export function createEmptyApplication(): Application {
	return {
		id: 0,
		companyName: "",
		jobTitle: "",
		industry: "",
		location: "",
		contractType: "CDI",
		applicationDate: "",
		applicationSource: "OTHER",
		status: "BROUILLON",
		nextActionDate: "",
		contactName: "",
		contactMail: "",
		jobOfferUrl: "",
		notes: "",
		createdAt: "",
		updatedAt: ""
	}
}