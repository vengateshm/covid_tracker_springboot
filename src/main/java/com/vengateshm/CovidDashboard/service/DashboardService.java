package com.vengateshm.CovidDashboard.service;

import com.vengateshm.CovidDashboard.model.StateCovidSummary;
import com.vengateshm.CovidDashboard.repository.CovidSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    public CovidSummaryRepository repository;

    public List<StateCovidSummary> findAll() {
        return repository.findAll();
    }


    public StateCovidSummary findByState(String stateName) {
        return repository.findByState(stateName);
    }
}
