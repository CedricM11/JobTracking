<template>
	<RouterLink class="btn btn-primary" :to="{name: 'new'}">New Application</RouterLink>
	<div class="container m-auto">
		<ApplicationTable />
	</div>
</template>

<script setup lang="ts">
	import ApplicationTable from '@/components/ApplicationTable.vue';
</script>