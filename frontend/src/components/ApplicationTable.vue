<template>
	<BaseAlert
		v-if="error"
		level="error"
		:message="error"
		@close="error=null"
	/>
	<div class="rounded-2xl bg-base-100 shadow-sm">
		<div class="overflow-x-auto">
			<table class="table">
				<thead>
					<tr class="text-base-content">
						<th>Company</th>
						<th>Job title</th>
						<th>Application date</th>
						<th>Status</th>
						<th>Next action</th>
						<th class="text-right">Actions</th>
					</tr>
				</thead>
				<tbody>
					<ApplicationRow
						v-for="application in applications"
						:key="application.id"
						:application="application"
						@delete="deleteApplication" />
				</tbody>
			</table>
		</div>
	</div>
</template>

<script setup lang="ts">
	import { onMounted } from 'vue';
	import { useApplications } from '@/composables/useApplications.ts';
	import ApplicationRow from './ApplicationRow.vue';
	import BaseAlert from './BaseAlert.vue';

	const { applications, error, loadApplications, deleteApplication } = useApplications();

	onMounted(async () => {
		await loadApplications();
	})
</script>