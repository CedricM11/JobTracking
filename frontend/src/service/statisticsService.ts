import api from "./api";
import type { StatisticsPreview } from "@/types/statistics";

export function getStatisticsPreview() {
	return api.get<StatisticsPreview>("/statistics/preview")
}