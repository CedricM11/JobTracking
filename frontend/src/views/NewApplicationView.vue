<template>
	<div class="flex items-center gap-4 p-4">
		<RouterLink :to="{ name: 'home' }">
			<div class="btn btn-circle">
				<ArrowLeft class="h-6 w-6 text-primary"/>
			</div>
		</RouterLink>
		<div>
			<h1 class="text-2xl font-bold text-base-content tracking-tight">New application</h1>
			<p class="text-sm text-base-content/70">add a new job application to keep track of your progress</p>
		</div>
	</div>
	<p v-if="error" class="text-error">{{ error }}</p>
	<ApplicationForm @submit="handleSubmit" />
</template>

<script setup lang="ts">
	import ApplicationForm from '@/components/ApplicationForm.vue';
	import { createApplicationService } from '@/service/applicationService';
	import type { Application, CreateApplicationPayload } from '@/types/application';
	import { ref } from 'vue';
	import { useRouter } from 'vue-router';

	import { ArrowLeft } from '@lucide/vue';


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