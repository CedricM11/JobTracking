<template>
	<aside class="flex h-full w-64 shrink-0 flex-col border-r border-base-300 bg-base-100 p-4">
		<div class="px-2 py-4 flex items-center gap-4">
			<div class="w-10 h-10 bg-primary/10 rounded-md text-primary flex justify-center items-center">
				<BriefcaseBusiness />
			</div>
			<h1 class="text-xl font-bold">JobTracking</h1>
		</div>

		<div class="divider mt-1"></div>

		<ul class="menu rounded-box w-full">
			<li>
				<RouterLink
					:to="{ name: 'home' }"
					class="flex items-center gap-3 rounded-lg px-3 py-2 mb-3 font-semibold"
					active-class="bg-primary/10 text-primary"
				>
					<House class="h-5 w-5" />
					<span>Dashboard</span>
				</RouterLink>
			</li>

			<li>
				<RouterLink
					to="/d"
					class="flex items-center gap-3 rounded-lg px-3 py-2 mb-3 font-semibold"
					active-class="bg-primary/10 text-primary"
				>
					<ChartSpline class="h-5 w-5" />
					<span>Statistics</span>
				</RouterLink>
			</li>

			<li>
				<RouterLink
					to="/de"
					class="flex items-center gap-3 rounded-lg px-3 py-2 mb-3 font-semibold"
					active-class="bg-primary/10 text-primary"
				>
					<Settings class="h-5 w-5" />
					<span>Settings</span>
				</RouterLink>
			</li>
		</ul>
	</aside>
</template>

<script setup lang="ts">
	import { BriefcaseBusiness, ChartSpline, House, Settings } from '@lucide/vue';
</script>
