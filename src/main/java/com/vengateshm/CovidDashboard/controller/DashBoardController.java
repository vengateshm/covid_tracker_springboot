package com.vengateshm.CovidDashboard.controller;

import com.vengateshm.CovidDashboard.model.StateCovidSummary;
import com.vengateshm.CovidDashboard.response.DashboardSummaryResponse;
import com.vengateshm.CovidDashboard.service.DashboardService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class DashBoardController {

    final DashboardService service;

    public DashBoardController(DashboardService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/dashboardSummary")
    public DashboardSummaryResponse getDashboardSummary() {
        List<StateCovidSummary> stateCovidSummaries = this.service.findAll();
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

    @GetMapping("/api/v1/summary/{stateName}")
    public StateCovidSummary getStateCovidSummary(@PathVariable String stateName) {
        return this.service.findByState(stateName);
    }
}
