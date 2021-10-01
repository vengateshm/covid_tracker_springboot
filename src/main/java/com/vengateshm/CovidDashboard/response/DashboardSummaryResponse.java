package com.vengateshm.CovidDashboard.response;

public class DashboardSummaryResponse {
    private int totalStates;
    private int totalCases;
    private int totalDeaths;
    private int totalRecovered;
    private int totalActiveCases;
    private int totalTests;
    private int totalPopulation;

    public int getTotalStates() {
        return totalStates;
    }

    public void setTotalStates(int totalStates) {
        this.totalStates = totalStates;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public int getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public int getTotalActiveCases() {
        return totalActiveCases;
    }

    public void setTotalActiveCases(int totalActiveCases) {
        this.totalActiveCases = totalActiveCases;
    }

    public int getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(int totalTests) {
        this.totalTests = totalTests;
    }

    public int getTotalPopulation() {
        return totalPopulation;
    }

    public void setTotalPopulation(int totalPopulation) {
        this.totalPopulation = totalPopulation;
    }
}
