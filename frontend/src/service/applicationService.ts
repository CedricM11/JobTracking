import api from "./api";
import type { Application, CreateApplicationPayload } from "@/types/application";

export function getApplications() {
	return api.get<Application[]>("/applications");
}

export function getApplicationByIdService(id: string) {
	return api.get<Application>(`/applications/${id}`);
}

export function createApplicationService(application: CreateApplicationPayload) {
	return api.post<CreateApplicationPayload>("/applications", application);
}

export function updateApplicationService(application: Application) {
	return api.put<Application>(`/applications/${application.id}`, application);
}