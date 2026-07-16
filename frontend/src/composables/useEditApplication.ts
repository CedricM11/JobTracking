import { getApplicationByIdService, updateApplicationService } from "@/service/applicationService";
import type { Application } from "@/types/application";
import { ref } from "vue";
import { useRouter } from "vue-router";

export function useEditApplication() {

	const application = ref<Application | null>(null);
	const error = ref<string | null>(null);
	const router = useRouter();

	async function loadApplicationById(id: string) {
		error.value = null;

		try {
			const response = await getApplicationByIdService(id);
			application.value = response.data;
		} catch(err) {
			console.error(err);
			error.value = "Unable to load application";
		}
	}

	async function updateApplication(app: Application) {
		error.value = null;

		try {
			await updateApplicationService(app);
			await router.push({ name: "home" });
		} catch(err) {
			console.error(err);
			error.value = "Unable to update application";
		}
	}

	return {
		application,
		error,
		loadApplicationById,
		updateApplication
	}
}