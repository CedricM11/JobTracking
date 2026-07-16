<!-- <template>
	<div class="flex min-h-screen">
		<Sidebar />
		<main class="flex-1 overflow-auto">
			<RouterView />
		</main>
	</div>
</template>

<script setup lang="ts">
	import Sidebar from './layout/Sidebar.vue';
</script> -->


<template>
	<div class="drawer lg:drawer-open">
		<input id="app-drawer" type="checkbox" class="drawer-toggle" />

		<div class="drawer-content flex min-h-screen flex-col bg-base-200">
			<!-- Top bar mobile -->
			<div class="navbar sticky top-0 z-30 border-b border-base-300 bg-base-100/80 backdrop-blur lg:hidden">
				<div class="flex-none">
					<label for="app-drawer" class="btn btn-square btn-ghost">
						<Menu class="h-5 w-5" />
					</label>
				</div>
				<div class="flex-1">
					<span class="text-lg font-semibold">JobTracking</span>
				</div>
			</div>

			<main class="flex-1 p-4 lg:p-6">
				<RouterView />
			</main>
		</div>

		<div class="drawer-side">
			<label for="app-drawer" class="drawer-overlay"></label>
			<Sidebar />
		</div>
	</div>
</template>

<script setup lang="ts">
	import { Menu } from '@lucide/vue';
	import Sidebar from './layout/Sidebar.vue';
</script>
```