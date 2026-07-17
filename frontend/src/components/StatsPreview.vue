<template>
	<BaseAlert
		v-if="error"
		level="error"
		:message="error"
		@close="error=null"
	/>
	<div class="grid grid-cols-1 md:grid-cols-5 gap-4">
		<StatCard
			title="Applications sent"
			:value="statsPreview?.sent ?? 0"
			:icon="Send"
			color="primary"
		/>
		<StatCard
			title="Waiting for a response"
			:value="statsPreview?.pending ?? 0"
			:icon="Hourglass"
			color="warning"
		/>
		<StatCard
			title="Interviews"
			:value="statsPreview?.interviews ?? 0"
			:icon="Users"
			color="primary"
		/>
		<StatCard
			title="Positives"
			:value="statsPreview?.positive ?? 0"
			:icon="CircleCheckBig"
			color="success"
		/>
		<StatCard
			title="Rejects"
			:value="statsPreview?.rejected ?? 0"
			:icon="X"
			color="error"
		/>
	</div>
</template>

<script setup lang="ts">
	import StatCard from './StatCard.vue';
	import BaseAlert from './BaseAlert.vue';
	import { onMounted, ref } from 'vue';
	import { Send, Hourglass, Users, CircleCheckBig, X } from '@lucide/vue';
	import { useStatsPreview } from '@/composables/useStatsPreview.ts';

	const { statsPreview, error, loadStatisticsPreview } = useStatsPreview();

	onMounted(async () => {
		await loadStatisticsPreview();
	});
</script>