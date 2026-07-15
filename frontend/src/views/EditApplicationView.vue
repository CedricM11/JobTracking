<template>
	<h1>Edit application</h1>
	<p>edition de la candidature : {{ id }}</p>
	<p v-if="error" class="text-error">{{ error }}</p>
	<ApplicationForm
		v-if="application"
		:application="application"
		@submit="handleSubmit" />
</template>

<script setup lang="ts">
	import ApplicationForm from '@/components/ApplicationForm.vue';
	import { getApplicationByIdService, updateApplicationService } from '@/service/applicationService';
	import type { Application } from '@/types/application';
	import { onMounted, ref } from 'vue';
	import { useRouter } from 'vue-router';

	const props = defineProps<{
		id: string
	}>();

	const router = useRouter();
	const application = ref<Application | null>(null);
	const error = ref<string | null>(null);

	async function handleSubmit(app: Application) {
		try {
			await updateApplicationService(app);
			await router.push({ name: "home" });
		} catch(err) {
			console.error(err);
			error.value = "Unable to update application";
		}
	}

	onMounted(async () => {
		error.value = null;

		try {
			const response = await getApplicationByIdService(props.id);
			application.value = response.data;
		} catch(err) {
			console.error(err);
			error.value = "Unable to load application";
		}
	});

</script>