import type { Application } from "@/types/application";
import { createEmptyApplication } from "@/utils/ApplicationFactory";
import { ref } from "vue";

export function useApplicationForm() {

	const form = ref<Application>(createEmptyApplication());
	const error = ref<string | null>(null);
	const fieldErrors = ref({
		companyName: '',
		jobTitle: '',
		status: '',
		applicationDate: '',
		contactMail: '',
		jobOfferUrl: '',
	});

	function clearErrors() {
		fieldErrors.value.companyName = '';
		fieldErrors.value.jobTitle = '';
		fieldErrors.value.status = '';
		fieldErrors.value.applicationDate = '';
		fieldErrors.value.contactMail = '';
		fieldErrors.value.jobOfferUrl = '';
	}

	function isValidForm() {
		clearErrors();

		let isValid = true;

		if(!form.value.companyName.trim()) {
			fieldErrors.value.companyName = "Company is required";
			isValid = false;
		}

		if(!form.value.jobTitle.trim()) {
			fieldErrors.value.companyName = "Job title is required";
			isValid = false;
		}

		if (!form.value.status) {
			fieldErrors.value.status = 'Status is required';
			isValid = false;
		}

		if (!form.value.applicationDate) {
			fieldErrors.value.applicationDate = 'Application date is required';
			isValid = false;
		}

		if (form.value.contactMail && !/^\S+@\S+\.\S+$/.test(form.value.contactMail)) {
			fieldErrors.value.contactMail = 'Invalid email address';
			isValid = false;
		}

		if (form.value.jobOfferUrl && !/^https?:\/\/.+/i.test(form.value.jobOfferUrl)) {
			fieldErrors.value.jobOfferUrl = 'Invalid URL';
			isValid = false;
		}

		return isValid;
	}

	return {
		form,
		error,
		fieldErrors,
		clearErrors,
		isValidForm
	}
}