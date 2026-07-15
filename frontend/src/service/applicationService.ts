import api from "./api";
import type { Application } from "@/types/application";

export function getApplications() {
	return api.get<Application[]>("/applications");
}