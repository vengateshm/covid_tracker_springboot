package com.vengateshm.CovidDashboard.repository;

import com.vengateshm.CovidDashboard.model.StateCovidSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidSummaryRepository extends JpaRepository<StateCovidSummary, String> {
    StateCovidSummary findByState(String state);
}
