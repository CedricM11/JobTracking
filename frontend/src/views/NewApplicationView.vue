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
	<ApplicationForm @submit="createApplication" />
</template>

<script setup lang="ts">
	import ApplicationForm from '@/components/ApplicationForm.vue';
	import { useNewApplication } from '@/composables/useNewApplication';
	import { ArrowLeft } from '@lucide/vue';

	const { error, createApplication } = useNewApplication();
</script>