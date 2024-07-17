<template>
  <div class="weekly-courses-overview grid-container">
    <h2>Wöchentliche Kurse verwalten</h2>
    <div class="table">
    </div>
    <ErrorBox ref="errorBox"/>
    <div v-if="this.weeklyCourses.courseDtos.length === 0" class="weekly-courses-placeholder"/>
  </div>
</template>
<script>
import PlannerApi from '../../mixins/PlannerApi';
import CommonTimeSlotPlannerRestApi from '../../mixins/CommonTimeSlotPlannerRestApi';
import ErrorBox from "@/components/error/ErrorBox.vue";
import ErrorHandlingService from "@/services/error/error-handling.service";

export default {
  name: 'PlannerOverview',
  mixins: [PlannerApi, CommonTimeSlotPlannerRestApi],
  components: {
    ErrorBox
  },
  computed: {
    plannerDto: function () {
      return this.$store.state.timeslotplanner.plannerDto
    },
  },
  methods: {
    /*
    * In case of an error during fetching the courses -> reset the current courses since we don't
    * actual< know what values would be loaded
    * and set the error details
     */
    fetchWeeklyCoursesErrorCallbackHandler: function (error) {
      this.resetWeeklyCourseDtosAndStore();
      this.handleError(error);
    },
    handleError: function (error) {
      ErrorHandlingService.handleError(this.$refs.errorBox, error);
    },
  },
  mounted() {
    this.calculatePlanner(error => this.fetchWeeklyCoursesErrorCallbackHandler(error), '01.01.2024', '31.12.2024');
  }
}</script>

<style scoped>

.weekly-courses-overview {
  overflow-y: hidden;
  display: flex;
  height: auto;
  justify-content: space-between;
  flex-direction: column;
}

.table {
  /*overflow-x: auto;*/
}

.table-cell {
  padding-left: 13px;
}

label {
  word-break: break-all;
}

.isPaused {
  background: lightslategray;
}

.isAppPaused {
  background: lightgrey;
}

.hasNoCourseDef {
  background: #ffcccb;
  border: firebrick solid 2px !important;
  border-radius: 5px;
}

.pause-button {
  background: url("../../assets/pause.svg") transparent no-repeat center;
  background-size: 90% 90%;
}

.delete-button {
  background: url("../../assets/trash.png") transparent no-repeat center;
  background-size: 90% 90%;
}

.table-button {
  margin: auto;
  height: 25px;
  width: 25px;
  cursor: pointer;
  border-radius: 5px;
  box-shadow: inset 0 3px 6px rgba(0, 0, 0, 0.16), 0 4px 6px rgba(0, 0, 0, 0.45);
}

.inactive-table-button {
  margin: auto;
  height: 25px;
  width: 25px;
  cursor: auto;
  border-radius: 5px;
  box-shadow: inset 0 3px 6px rgba(0, 0, 0, 0.16), 0 4px 6px rgba(0, 0, 0, 0.45);
}

.current-course-star {
  background: url('../../assets/glocke.png') transparent no-repeat center;
}

.cell-icon {
  height: 15px;
  width: 15px;
  padding-right: 25px;
  background-size: 90% 90%;
  margin-right: 5px;
}

.no-course-def-warning {
  background: url('../../assets/warning.svg') transparent no-repeat center;
}

.weekly-courses-placeholder {
  flex-grow: 2;
}

.course-programm-link {
  align-self: center;
}
</style>