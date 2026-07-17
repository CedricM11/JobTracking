<template>
	<div class="grid grid-cols-1 md:grid-cols-5 gap-4">
		<StatCard
			title="Applications sent"
			value="5"
			:icon="Send"
			color="primary"
		/>
		<StatCard
			title="Waiting for a response"
			value="5"
			:icon="Hourglass"
			color="warning"
		/>
		<StatCard
			title="Interviews"
			value="5"
			:icon="Users"
			color="primary"
		/>
		<StatCard
			title="Positives"
			value="5"
			:icon="CircleCheckBig"
			color="success"
		/>
		<StatCard
			title="Rejects"
			value="5"
			:icon="X"
			color="error"
		/>
	</div>
</template>

<script setup lang="ts">
	import StatCard from './StatCard.vue';
	import { Send, Hourglass, Users, CircleCheckBig, X } from '@lucide/vue';
</script>