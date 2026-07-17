<template>
	<RouterLink class="btn btn-primary" :to="{name: 'new'}">New Application</RouterLink>
	<StatsPreview />
	<div class="container m-auto">
		<ApplicationTable />
	</div>
</template>

<script setup lang="ts">
	import ApplicationTable from '@/components/ApplicationTable.vue';
	import StatsPreview from '@/components/StatsPreview.vue';
</script>