<template>
	<h1>This is the dashboard</h1>
	<ul v-for="app in applications">
		<li>{{ app.companyName }}</li>
	</ul>
</template>

<script setup lang="ts">
	import axios from 'axios';
	import { onMounted, ref } from 'vue';

	type Application = {
		id: number
		applicationDate: string
		applicationSource: string
		companyName: string
		contactMail: string
		contactName: string
		contractType: string
		createdAt: string
		industry: string
		jobOfferUrl: string
		jobTitle: string
		location: string
		nextActionDate: string
		notes: string
		status: string
		updatedAt: string
	}

	const applications = ref<Application[]>([]);

	onMounted( async () => {
		const response = await axios.get<Application[]>("http://localhost:8080/api/v1/applications")
		applications.value = response.data;
	})

</script>