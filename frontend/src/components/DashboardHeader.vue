<template>
	<div class="flex items-center justify-between mt-4">
		<div class="mb-5">
			<h1 class="text-2xl font-bold text-base-content tracking-tight">Hello Cedric ​👋​</h1>
			<p class="text-sm text-base-content/70">Here is an overview of your applications</p>
		</div>
		<div class="flex items-center gap-x-4">
			<label class="input">
				<Search class="w-5 h-5"/>
				<input type="search" required placeholder="Search" />
			</label>
			<RouterLink class="btn btn-primary" :to="{ name: 'new' }">
				<CirclePlus class="w-5 h-5"/>
				<span>New Application</span>
			</RouterLink>
		</div>
	</div>
</template>

<script setup lang="ts">
	import { CirclePlus, Search } from '@lucide/vue';
</script>