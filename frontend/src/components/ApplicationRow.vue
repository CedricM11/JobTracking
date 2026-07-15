<template>
	<tr>
		<td class="text-base-content/80">{{ application.companyName }}</td>
		<td class="text-base-content/80">{{ application.jobTitle }}</td>
		<td class="text-base-content/80">{{ application.applicationDate }}</td>
		<td>
			<StatusBadge
				:label="statusMeta[application.status].label"
				:badgeClass="statusMeta[application.status].badgeClass"
			/>
		</td>
		<td class="text-base-content/80">{{ application.nextActionDate }}</td>
		<td class="text-right">
			<RouterLink
				class="btn btn-sm btn-ghost"
				:to="{ name: 'edit', params: { id: application.id } }">
				Edit
			</RouterLink>
		</td>
	</tr>
</template>

<script setup lang="ts">
	import StatusBadge from './StatusBadge.vue';
	import type { Application, ApplicationStatus } from '@/types/application';

	const props = defineProps<{
		application: Application
	}>();

	const statusMeta: Record<ApplicationStatus, { label: string; badgeClass: string }> = {
		BROUILLON:    { label: 'Draft',     badgeClass: 'badge-neutral' },
		A_ENVOYER:    { label: 'To send',   badgeClass: 'badge-warning' },
		ENVOYEE:      { label: 'Sent',      badgeClass: 'badge-info' },
		A_RELANCER:   { label: 'Follow up', badgeClass: 'badge-warning' },
		ENTRETIEN:    { label: 'Interview', badgeClass: 'badge-primary' },
		OFFRE:        { label: 'Offer',     badgeClass: 'badge-success' },
		REFUSEE:      { label: 'Rejected',  badgeClass: 'badge-error' },
		ABANDONNEE:   { label: 'Dropped',   badgeClass: 'badge-neutral' },
	}
</script>