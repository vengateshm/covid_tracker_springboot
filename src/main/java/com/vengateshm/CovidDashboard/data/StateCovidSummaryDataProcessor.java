package com.vengateshm.CovidDashboard.data;

import com.vengateshm.CovidDashboard.model.StateCovidSummary;
import org.springframework.batch.item.ItemProcessor;

public class StateCovidSummaryDataProcessor implements ItemProcessor<StateCovidSummaryInput, StateCovidSummary> {
    @Override
    public StateCovidSummary process(StateCovidSummaryInput covidInput) throws Exception {
        StateCovidSummary stateCovidSummary = new StateCovidSummary();

        stateCovidSummary.setState(covidInput.getState());
        stateCovidSummary.setTotalCases(getValidDouble(covidInput.getTotalCases()));
        stateCovidSummary.setTotalDeaths(getValidDouble(covidInput.getTotalDeaths()));
        stateCovidSummary.setTotalRecovered(getValidDouble(covidInput.getTotalRecovered()));
        stateCovidSummary.setActiveCases(getValidDouble(covidInput.getActiveCases()));
        stateCovidSummary.setTestsPerOneMilPopulation(getValidDouble(covidInput.getTotalCasesPerOneMilPopulation()));
        stateCovidSummary.setDeathPerOneMilPopulation(getValidDouble(covidInput.getDeathPerOneMilPopulation()));
        stateCovidSummary.setTotalTests(getValidDouble(covidInput.getTotalTests()));
        stateCovidSummary.setTestsPerOneMilPopulation(getValidDouble(covidInput.getTestsPerOneMilPopulation()));
        stateCovidSummary.setPopulation(getValidDouble(covidInput.getPopulation()));

        return stateCovidSummary;
    }

    public double getValidDouble(String value) {
        if (value.equals("null") || value.trim().isBlank() || value.trim().isEmpty()) {
            return 0.0;
        } else {
            return Double.parseDouble(value);
        }
    }
}
