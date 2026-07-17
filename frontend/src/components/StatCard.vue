<template>
	<div class="stats shadow bg-base-100">
		<div class="stat flex gap-5">
			<div class="stat-figure rounded-full p-3 flex items-center justify-center" :class="StatClass">
				<component :is="icon" class="w-6 h-6"/>
			</div>
			<div>
				<div class="stat-title">{{ title }}</div>
				<div class="stat-value">{{ value }}</div>
			</div>
		</div>
	</div>
</template>

<script setup lang="ts">
	import { computed, type Component } from 'vue';

	type ColorLevel = "primary" | "warning" | "success" | "error";

	const props = defineProps<{
		title: string
		value: number | string
		icon: Component
		color: ColorLevel
	}>();

	const StatClass = computed(() => {
		if (props.color === "warning")
			return "bg-warning/10 text-warning";
		else if (props.color === "success")
			return "bg-success/10 text-success";
		else if (props.color === "error")
			return "bg-error/10 text-error";
		else
			return "bg-primary/10 text-primary";
	});
</script>