package com.vengateshm.CovidDashboard.controller;

import com.vengateshm.CovidDashboard.model.StateCovidSummary;
import com.vengateshm.CovidDashboard.response.DashboardSummaryResponse;
import com.vengateshm.CovidDashboard.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
public class DashBoardController {

    final DashboardService service;

    public DashBoardController(DashboardService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/summary/dashBoard")
    public DashboardSummaryResponse getDashboardSummary() {
        return this.service.getDashboardSummary();
    }

    @GetMapping("/api/v1/summary/allStates")
    public List<StateCovidSummary> getAllStateSummary() {
        return this.service.findAll();
    }

    @GetMapping("/api/v1/summary/{stateName}")
    public StateCovidSummary getStateCovidSummary(@PathVariable String stateName) {
        return this.service.findByState(stateName);
    }

    @PostMapping("/api/v1/summary")
    public ResponseEntity<Void> saveCovidSummary(@RequestBody StateCovidSummary summary) {
        StateCovidSummary savedSummary = service.save(summary);
        if (savedSummary == null) return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).build();
    }
}
