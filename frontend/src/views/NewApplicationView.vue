<template>
	<h1>New application</h1>
	<p v-if="error" class="text-error">{{ error }}</p>
	<ApplicationForm @submit="handleSubmit" />
</template>

<script setup lang="ts">
	import ApplicationForm from '@/components/ApplicationForm.vue';
	import { createApplicationService } from '@/service/applicationService';
	import type { Application, CreateApplicationPayload } from '@/types/application';
	import { ref } from 'vue';
	import { useRouter } from 'vue-router';


	const error = ref<string | null>(null);
	const router = useRouter();

	function createPayload(application : Application) : CreateApplicationPayload {
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

	async function handleSubmit(application: Application) {
		try {
			const payload = createPayload(application);
			await createApplicationService(payload);
			await router.push({ name: "home" });
		} catch (err) {
			console.error(err);
			error.value = "Unable to create application";
		}
	}
</script>