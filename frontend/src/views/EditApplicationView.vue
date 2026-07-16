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
		@submit="updateApplication" />
</template>

<script setup lang="ts">
	import ApplicationForm from '@/components/ApplicationForm.vue';
	import { useEditApplication } from '@/composables/useEditApplication';
	import { ArrowLeft } from '@lucide/vue';
	import { onMounted } from 'vue';

	const { application, error, loadApplicationById, updateApplication } = useEditApplication();

	const props = defineProps<{
		id: string
	}>();

	onMounted(async () => {
		loadApplicationById(props.id);
	});

</script>