const APP_OFFLINE_TXT = 'Application offline';
export const timeslotplanner = {
    namespaced: true,
    state: () => ({
        isLoading: false,
        plannerDto: {
            validFrom: null,
            plannerDays: [],
        },
    }),
    getters: {
        plannerDto(state) {
            return state.plannerDto;
        },
        isLoading(state) {
            return state.isLoading;
        }
    },
    mutations: {
        setPlannerDto(state, plannerDto) {
            state.plannerDto = plannerDto;
        },
        setIsLoading(state, isLoading) {
            state.isLoading = isLoading;
        }
    },
    actions: {
        setPlannerDto(context, plannerDto) {
            context.commit("setPlannerDto", plannerDto);
        },
        setIsLoading(context, isLoading) {
            context.commit("setIsLoading", isLoading);
        }
    },
};
