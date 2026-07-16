<template>
	<div class="flex items-center gap-4 p-4">
		<RouterLink :to="{ name: 'home' }">
			<div class="btn btn-circle">
				<ArrowLeft class="h-6 w-6 text-primary"/>
			</div>
		</RouterLink>
		<div>
			<h1 class="text-2xl font-bold text-base-content tracking-tight">Edit application</h1>
			<p class="text-sm text-base-content/70">add an existing application to keep track of your progress</p>
		</div>
	</div>
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

	import { ArrowLeft } from '@lucide/vue';

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