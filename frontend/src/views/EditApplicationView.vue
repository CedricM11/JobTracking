<template>
	<h1>Edit application</h1>
	<p>edition de la candidature : {{ id }}</p>
	<ApplicationForm />
</template>

<script setup lang="ts">
	import ApplicationForm from '@/components/ApplicationForm.vue';

	const props = defineProps<{
		id: string
	}>();
	
</script>