package com.vengateshm.CovidDashboard;

import com.vengateshm.CovidDashboard.model.StateCovidSummary;
import com.vengateshm.CovidDashboard.repository.CovidSummaryRepository;
import com.vengateshm.CovidDashboard.service.DashboardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DashBoardServiceTest {
    @Autowired
    private DashboardService service;

    @MockBean
    private CovidSummaryRepository repository;

    @Test
    public void testAllStateSummary() {
        when(repository.findAll()).thenReturn(
                Stream.of(new StateCovidSummary("Alabama"),
                                new StateCovidSummary("Alaska"))
                        .collect(Collectors.toList()));

        assertEquals(2, service.findAll().size());
    }

    @Test
    public void testFindByState() {
        String state = "Alabama";
        when(repository.findByState(state)).thenReturn(new StateCovidSummary("Alabama"));

        assertEquals("Alabama", service.findByState(state).getState());
    }

    @Test
    public void testSaveStateSummary() {
        StateCovidSummary summary = new StateCovidSummary("Alaska");
        when(repository.save(summary)).thenReturn(summary);

        assertEquals(summary, service.save(summary));
    }

    @Test
    public void testDeleteStateSummary() {
        StateCovidSummary summary = new StateCovidSummary("Alaska");
        service.delete(summary);

        verify(repository, times(1)).delete(summary);
    }
}
