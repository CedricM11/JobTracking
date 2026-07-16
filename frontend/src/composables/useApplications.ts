import { deleteApplicationService, getApplications } from "@/service/applicationService";
import type { Application } from "@/types/application";
import { ref } from "vue";

export function useApplications() {

	const error = ref<string | null>(null);
	const applications = ref<Application[] | null>(null);

	async function loadApplications() {
		error.value = null;

		try {
			const response = await getApplications();
			applications.value = response.data;
		} catch(err) {
			error.value = "Enable to load applications data";
			console.error(err);
		}
	}

	async function deleteApplication(id: string) {
		error.value = null;

		try {
			await deleteApplicationService(id);
			if (!applications.value) return;
			applications.value = applications.value.filter(app => app.id.toString() !== id);
		} catch(err) {
			error.value = "Enable to delete application";
			console.error(err);
		}
	}

	return {
		applications,
		error,
		loadApplications,
		deleteApplication
	}
}