<template>
	<p v-if="error" class="text-error">{{ error }}</p>
	<div class="rounded-2xl bg-base-100 shadow-sm">
		<div class="overflow-x-auto">
			<table class="table table-zebra">
				<thead>
					<tr class="text-base-content/50">
						<th>Company</th>
						<th>Job title</th>
						<th>Application date</th>
						<th>Status</th>
						<th>Next action</th>
						<th class="text-right">Actions</th>
					</tr>
				</thead>
				<tbody>
					<ApplicationRow v-for="application in applications" :key="application.id" :application="application"/>
				</tbody>
			</table>
		</div>
	</div>
</template>

<script setup lang="ts">
	import { onMounted, ref } from 'vue';
	import type { Application } from '@/types/application';
	import { getApplications } from '@/service/applicationService';
	import ApplicationRow from './ApplicationRow.vue';

	const applications = ref<Application[]>([]);
	const error = ref<string | null>(null);

	onMounted(async () => {
		error.value = null;
		try {
			const response = await getApplications();
			applications.value = response.data;
		} catch (err) {
			error.value = "Enable to load applications data";
			console.error("Error: ", err);
		}
	})
</script>