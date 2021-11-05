package com.vengateshm.CovidDashboard.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "state_covid_summary")
public class StateCovidSummary {
    // JPA by default converts camel case to underscore table column names
    @Id
    private String state;
    private double totalCases;
    private double totalDeaths;
    private double totalRecovered;
    private double activeCases;
    private double totalCasesPerOneMilPopulation;
    private double deathPerOneMilPopulation;
    private double totalTests;
    private double testsPerOneMilPopulation;
    private double population;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(double totalCases) {
        this.totalCases = totalCases;
    }

    public double getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(double totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public double getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(double totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public double getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(double activeCases) {
        this.activeCases = activeCases;
    }

    public double getTotalCasesPerOneMilPopulation() {
        return totalCasesPerOneMilPopulation;
    }

    public void setTotalCasesPerOneMilPopulation(double totalCasesPerOneMilPopulation) {
        this.totalCasesPerOneMilPopulation = totalCasesPerOneMilPopulation;
    }

    public double getDeathPerOneMilPopulation() {
        return deathPerOneMilPopulation;
    }

    public void setDeathPerOneMilPopulation(double deathPerOneMilPopulation) {
        this.deathPerOneMilPopulation = deathPerOneMilPopulation;
    }

    public double getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(double totalTests) {
        this.totalTests = totalTests;
    }

    public double getTestsPerOneMilPopulation() {
        return testsPerOneMilPopulation;
    }

    public void setTestsPerOneMilPopulation(double testsPerOneMilPopulation) {
        this.testsPerOneMilPopulation = testsPerOneMilPopulation;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public StateCovidSummary() {
    }

    public StateCovidSummary(String state) {
        this.state = state;
    }
}
