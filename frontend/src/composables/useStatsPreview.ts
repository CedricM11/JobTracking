import { getStatisticsPreview } from "@/service/statisticsService";
import type { StatisticsPreview } from "@/types/statistics";
import { ref } from "vue";

export function useStatsPreview() {

	const statsPreview = ref<StatisticsPreview | null>(null);
	const error = ref<string | null>(null);

	async function loadStatisticsPreview() {
		error.value = null;

		try {
			const response = await getStatisticsPreview();
			statsPreview.value = response.data;
		} catch (err) {
			console.error(err);
			error.value = "Enable to load statistics preview"
		}
	}

	return {
		statsPreview,
		error,
		loadStatisticsPreview
	}
}