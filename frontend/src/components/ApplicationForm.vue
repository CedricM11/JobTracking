<template>
	<form class="card bg-base-100 shadow-lg p-4 mx-4 flex flex-col gap-4" @submit.prevent="submitForm">
		<div class="flex items-center gap-3">
			<div class="rounded-lg bg-primary/10 p-1.5 text-primary ring-1 ring-primary/20">
				<Info class="h-4 w-4" />
			</div>
			<h2 class="text-base text-primary font-semibold">General information</h2>
		</div>

		<div class="grid grid-cols-1 gap-x-4 md:grid-cols-2">
			<fieldset class="fieldset">
				<legend class="fieldset-legend">Company*</legend>
				<input v-model="form.companyName" class="input input-bordered w-full" type="text" placeholder="e.g. OpenAI" required />
			</fieldset>

			<fieldset class="fieldset">
				<legend class="fieldset-legend">Job title*</legend>
				<input v-model="form.jobTitle" class="input input-bordered w-full" type="text" placeholder="e.g. Backend Developer" required />
			</fieldset>

			<fieldset class="fieldset">
				<legend class="fieldset-legend">Industry</legend>
				<input v-model="form.industry" class="input input-bordered w-full" placeholder="e.g. Technology, Software" type="text" />
			</fieldset>

			<fieldset class="fieldset">
				<legend class="fieldset-legend">Location</legend>
				<input v-model="form.location" class="input input-bordered w-full" placeholder="e.g. Remote, Paris, France" type="text" />
			</fieldset>

			<fieldset class="fieldset">
				<legend class="fieldset-legend">Contract type</legend>
				<select v-model="form.contractType" class="select select-bordered w-full">
					<option value="CDI">CDI</option>
					<option value="CDD">CDD</option>
					<option value="ALTERNANCE">Alternance</option>
					<option value="STAGE">Stage</option>
					<option value="FREELANCE">Freelance</option>
				</select>
			</fieldset>

			<fieldset class="fieldset">
				<legend class="fieldset-legend">Source</legend>
				<select v-model="form.applicationSource" class="select select-bordered w-full">
					<option value="EMAIL">Email</option>
					<option value="LINKEDIN">LinkedIn</option>
					<option value="INDEED">Indeed</option>
					<option value="WELCOME_TO_THE_JUNGLE">Welcome to the Jungle</option>
					<option value="COMPANY_WEBSITE">Company website</option>
					<option value="PHONE">Phone</option>
					<option value="IN_PERSON">In person</option>
					<option value="OTHER">Other</option>
				</select>
			</fieldset>
		</div>

		<div class="grid grid-cols-1 gap-x-4 md:grid-cols-3">
			<fieldset class="fieldset">
				<legend class="fieldset-legend">Status*</legend>
				<select v-model="form.status" class="select select-bordered w-full">
					<option value="BROUILLON">Draft</option>
					<option value="A_ENVOYER">To send</option>
					<option value="ENVOYEE">Sent</option>
					<option value="A_RELANCER">Follow up</option>
					<option value="ENTRETIEN">Interview</option>
					<option value="OFFRE">Offer</option>
					<option value="REFUSEE">Rejected</option>
					<option value="ABANDONNEE">Dropped</option>
				</select>
			</fieldset>

			<fieldset class="fieldset">
				<legend class="fieldset-legend">Application date*</legend>
				<input v-model="form.applicationDate" class="input input-bordered w-full" type="date" required />
			</fieldset>

			<fieldset class="fieldset">
				<legend class="fieldset-legend">Next action date</legend>
				<input v-model="form.nextActionDate" class="input input-bordered w-full" type="date" />
			</fieldset>
		</div>

		<div class="divider my-1"></div>
		<div class="flex items-center gap-3">
			<div class="rounded-lg bg-primary/10 p-1.5 text-primary ring-1 ring-primary/20">
				<User class="h-4 w-4" />
			</div>
			<h2 class="text-base text-primary font-semibold">Contact information</h2>
		</div>

		<div class="grid grid-cols-1 gap-x-4 md:grid-cols-2">
			<fieldset class="fieldset">
				<legend class="fieldset-legend">Contact name</legend>
				<input v-model="form.contactName" class="input input-bordered w-full" placeholder="e.g. John Doe" type="text" />
			</fieldset>

			<fieldset class="fieldset">
				<legend class="fieldset-legend">Contact email</legend>
				<input v-model="form.contactMail" class="input input-bordered w-full" placeholder="e.g. john.doe@company.com" type="email" />
			</fieldset>

			<fieldset class="fieldset md:col-span-2">
				<legend class="fieldset-legend">Job offer URL</legend>
				<input v-model="form.jobOfferUrl" class="input input-bordered w-full" placeholder="e.g. https://company.com/careers/123" type="url" />
			</fieldset>
		</div>

		<div class="divider my-1"></div>
		<div class="flex items-center gap-3">
			<div class="rounded-lg bg-primary/10 p-1.5 text-primary ring-1 ring-primary/20">
				<Notebook class="h-4 w-4" />
			</div>
			<h2 class="text-base text-primary font-semibold">Notes</h2>
		</div>

		<div class="grid grid-cols-1 gap-x-4 md:grid-cols-2">
			<fieldset class="fieldset md:col-span-2">
				<legend class="fieldset-legend">Notes</legend>
				<textarea v-model="form.notes" class="textarea textarea-bordered w-full" placeholder="add any notes about this application" rows="4"></textarea>
			</fieldset>
		</div>

		<p v-if="error" class="text-error">{{ error }}</p>

		<div class="flex justify-end gap-2">
			<button class="btn btn-primary" type="submit">Save application</button>
		</div>
	</form>
</template>

<script setup lang="ts">
	import type { Application } from '@/types/application';
	import { createEmptyApplication } from '@/utils/ApplicationFactory';
	import { ref, watch, toRaw } from 'vue';

	import { Info } from '@lucide/vue';
	import { User } from '@lucide/vue';
	import { Notebook } from '@lucide/vue';

	const props = defineProps<{
		application?: Application
	}>();

	const emit = defineEmits<{
		submit: [application: Application]
	}>();

	const form = ref<Application>(createEmptyApplication());
	const error = ref<string | null>(null);

	watch(
		() => props.application,
		(newApplication) => {
			form.value = newApplication
				? structuredClone(toRaw(newApplication))
				: createEmptyApplication()
		},
		{ immediate: true },
	)

	function submitForm() {
		emit('submit', form.value);
	}
</script>