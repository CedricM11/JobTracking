<template>
	<Teleport to="body">
		<div class="fixed top-4 right-4 z-50">
			<div :class="alertClass" role="alert">
				<div class="space-y-1">
					<h3 class="font-semibold capitalize">{{ level }}</h3>
					<p class="text-sm">{{ message }}</p>
				</div>

				<button class="fixed top-6 right-6 btn btn-ghost btn-xs" type="button" @click="close">
					✕
				</button>
			</div>
		</div>
	</Teleport>
</template>

<script setup lang="ts">
	import { computed } from 'vue';

	type AlertLevel = "success" | "error" | "warning";

	const props = defineProps<{
		level: AlertLevel
		message: string
		duration?: number
	}>();

	const emit = defineEmits<{
		close: []
	}>();

	const alertClass = computed(() => {
		if (props.level === "success")
			return "alert alert-success shadow-lg";
		else if (props.level === "warning")
			return "alert alert-warning shadow-lg";
		else
			return "alert alert-error shadow-lg"
	});

	function close() {
		emit('close');
	}

</script>