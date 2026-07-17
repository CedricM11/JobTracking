<template>
	<div class="flex flex-col gap-y-6">
		<DashboardHeader />
		<StatsPreview />
		<ApplicationTable />
	</div>
</template>

<script setup lang="ts">
	import ApplicationTable from '@/components/ApplicationTable.vue';
	import StatsPreview from '@/components/StatsPreview.vue';
	import DashboardHeader from '@/components/DashboardHeader.vue';
</script>