import {createStore} from "vuex";
import {auth} from "./auth.module";
import {timeslotplanner} from "./planner.module";

const store = createStore({
    modules: {
        auth,
        timeslotplanner,
    },
});

export default store;
