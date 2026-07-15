<template>
	<span :class="[`badge`, `badge-soft`, badgeClass]">{{ label }}</span>
</template>

<script setup lang="ts">
	const props = defineProps<{
		label: string
		badgeClass: string
	}>();
</script>