package com.vengateshm.CovidDashboard.service;

import com.vengateshm.CovidDashboard.model.StateCovidSummary;
import com.vengateshm.CovidDashboard.repository.CovidSummaryRepository;
import com.vengateshm.CovidDashboard.response.DashboardSummaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    public CovidSummaryRepository repository;

    public DashboardSummaryResponse getDashboardSummary() {
        List<StateCovidSummary> stateCovidSummaries = this.repository.findAll();
        DashboardSummaryResponse response = new DashboardSummaryResponse();

        int totalStates = stateCovidSummaries.size();
        int totalCases = stateCovidSummaries.stream().mapToInt(value -> (int) value.getTotalCases()).sum();
        int totalDeaths = stateCovidSummaries.stream().mapToInt(value -> (int) value.getTotalDeaths()).sum();
        int totalRecovered = stateCovidSummaries.stream().mapToInt(value -> (int) value.getTotalRecovered()).sum();
        int totalActiveCases = stateCovidSummaries.stream().mapToInt(value -> (int) value.getActiveCases()).sum();
        int totalTests = stateCovidSummaries.stream().mapToInt(value -> (int) value.getTotalTests()).sum();
        int totalPopulation = stateCovidSummaries.stream().mapToInt(value -> (int) value.getPopulation()).sum();

        response.setTotalStates(totalStates);
        response.setTotalCases(totalCases);
        response.setTotalDeaths(totalDeaths);
        response.setTotalRecovered(totalRecovered);
        response.setTotalActiveCases(totalActiveCases);
        response.setTotalTests(totalTests);
        response.setTotalPopulation(totalPopulation);

        return response;
    }

    public List<StateCovidSummary> findAll() {
        return repository.findAll();
    }

    public StateCovidSummary findByState(String stateName) {
        return repository.findByState(stateName);
    }

    public StateCovidSummary save(StateCovidSummary summary) {
        return repository.save(summary);
    }

    public void delete(StateCovidSummary summary) {
        repository.delete(summary);
    }
}
