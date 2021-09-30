package com.vengateshm.CovidDashboard.data;

public class StateCovidSummaryInput {
    private String state;
    private String totalCases;
    private String totalDeaths;
    private String totalRecovered;
    private String activeCases;
    private String totalCasesPerOneMilPopulation;
    private String deathPerOneMilPopulation;
    private String totalTests;
    private String testsPerOneMilPopulation;
    private String population;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

    public String getTotalCasesPerOneMilPopulation() {
        return totalCasesPerOneMilPopulation;
    }

    public void setTotalCasesPerOneMilPopulation(String totalCasesPerOneMilPopulation) {
        this.totalCasesPerOneMilPopulation = totalCasesPerOneMilPopulation;
    }

    public String getDeathPerOneMilPopulation() {
        return deathPerOneMilPopulation;
    }

    public void setDeathPerOneMilPopulation(String deathPerOneMilPopulation) {
        this.deathPerOneMilPopulation = deathPerOneMilPopulation;
    }

    public String getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(String totalTests) {
        this.totalTests = totalTests;
    }

    public String getTestsPerOneMilPopulation() {
        return testsPerOneMilPopulation;
    }

    public void setTestsPerOneMilPopulation(String testsPerOneMilPopulation) {
        this.testsPerOneMilPopulation = testsPerOneMilPopulation;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
