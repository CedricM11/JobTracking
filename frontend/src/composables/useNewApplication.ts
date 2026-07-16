import { createApplicationService } from "@/service/applicationService";
import type { Application, CreateApplicationPayload } from "@/types/application";
import { ref } from "vue";
import { useRouter } from "vue-router";

export function useNewApplication() {

	const error = ref<string | null>(null);
	const router = useRouter();

	function createPayload(application: Application): CreateApplicationPayload {
		return {
			companyName: application.companyName,
			jobTitle: application.jobTitle,
			industry: application.industry,
			location: application.location,
			contractType: application.contractType,
			applicationDate: application.applicationDate,
			applicationSource: application.applicationSource,
			status: application.status,
			nextActionDate: application.nextActionDate,
			contactName: application.contactName,
			contactMail: application.contactMail,
			jobOfferUrl: application.jobOfferUrl,
			notes: application.notes
		}
	}

	async function createApplication(application: Application) {
		error.value = null;

		try {
			const payload = createPayload(application);
			await createApplicationService(payload);
			await router.push( {name: "home"} );
		} catch (err) {
			console.error(err);
			error.value = "Unable to create application";
		}
	}

	return {
		error,
		createApplication
	}

}