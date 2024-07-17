import {TIME_SLOT_PLANNER_API_URL} from '@/mixins/CommonTimeSlotPlannerRestApi';
import axios from "axios";
import store from "../store/index.js";
import timeSlotPlannerRestApi from '../mixins/CommonTimeSlotPlannerRestApi';
import authHeader from "@/services/auth/auth-header";
import LoggingService from "@/services/log/logging.service";

export default {
    name: 'PlannerApi',
    mixins: [timeSlotPlannerRestApi],
    methods: {
         calculatePlanner: function (onErrorCallback, beginDate, endDate) {
            axios.get(TIME_SLOT_PLANNER_API_URL + '/calculate-planner/' + beginDate + '/' + endDate + '', {headers: authHeader()})
                .then(response => response.data)
                .then(data => console.log('planner: ' + data))
                .then(data => store.dispatch('timeslotplanner/setPlannerDto', data))
                .catch(error => {
                    LoggingService.logError('Error occurred while fetching WeeklyCourses', error);
                    onErrorCallback(LoggingService.extractErrorText(error));
                });
        },
    }
}
