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
		<td>
			<div class="flex items-center justify-end gap-2">
				<RouterLink
					class="btn btn-sm btn-ghost"
					:to="{ name: 'edit', params: { id: application.id } }">
					<SquarePen class="h-4 w-4" />
				</RouterLink>
				<div class="btn btn-sm btn-ghost" @click="deleteDialog?.showModal()">
					<Trash2 class="h-4 w-4 text-error"/>
				</div>
			</div>
		</td>
	</tr>
	<dialog ref="deleteDialog" class="modal modal-bottom sm:modal-middle">
		<div class="modal-box">
			<h3 class="text-lg font-bold">Delete application</h3>
			<p class="py-4">Are you sure you want to delete this application ?</p>
			<div class="modal-action">
				<form method="dialog">
					<button class="btn btn-error" type="button" @click="handleDelete">Delete</button>
					<button class="btn">Cancel</button>
				</form>
			</div>
		</div>
	</dialog>
</template>

<script setup lang="ts">
	import StatusBadge from './StatusBadge.vue';
	import type { Application, ApplicationStatus } from '@/types/application';
	import { ref } from 'vue';
	import { Trash2 } from '@lucide/vue';
	import { SquarePen } from '@lucide/vue';
	import { deleteApplicationService } from '@/service/applicationService.ts';

	const props = defineProps<{
		application: Application
	}>();

	const emit = defineEmits<{
		deleted: [id: string]
	}>();

	const deleteDialog = ref<HTMLDialogElement | null>(null);

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

	async function handleDelete() {
		try {
			await deleteApplicationService(props.application.id.toString());
			deleteDialog.value?.close();
			emit("deleted", props.application.id.toString());
		} catch(err) {
			console.error(err);
		}
	}
</script>