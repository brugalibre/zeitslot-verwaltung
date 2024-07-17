import dayjs from "dayjs";

export const TIME_SLOT_PLANNER_API_URL = '/api/timeslotplanner/v1/planner';

export default {
    name: 'TimeSlotPlannerRestApi',
    methods: {
        formatDate(dateString) {
            const date = dayjs(dateString);
            return date.format('DD.MM.YYYY HH:mm');
        }
    }
}