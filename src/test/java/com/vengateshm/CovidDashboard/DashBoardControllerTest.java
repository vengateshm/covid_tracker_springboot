package com.vengateshm.CovidDashboard;

import com.vengateshm.CovidDashboard.controller.DashBoardController;
import com.vengateshm.CovidDashboard.model.StateCovidSummary;
import com.vengateshm.CovidDashboard.response.DashboardSummaryResponse;
import com.vengateshm.CovidDashboard.service.DashboardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DashBoardController.class)
public class DashBoardControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    DashboardService service;

    DashboardSummaryResponse response = new DashboardSummaryResponse();

    @Before
    public void setup() {
        response.setTotalStates(50);
        response.setTotalCases(41761664);
        response.setTotalDeaths(669723);
        response.setTotalRecovered(28931205);
        response.setTotalActiveCases(6620393);
        response.setTotalTests(607393651);
        response.setTotalPopulation(327533774);
    }

    @Test
    public void getDashBoardSummary() throws Exception {
        when(service.getDashboardSummary()).thenReturn(response);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/summary/dashBoard")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(mvcResult.getResponse());
        String expected = "{\"totalStates\":50,\"totalCases\":41761664,\"totalDeaths\":669723,\"totalRecovered\":28931205,\"totalActiveCases\":6620393,\"totalTests\":607393651,\"totalPopulation\":327533774}";

        JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
    }

    @Test
    public void saveStateSummary() throws Exception {
        StateCovidSummary mockStateCovidSummary = new StateCovidSummary();
        mockStateCovidSummary.setState("Alaska");
        mockStateCovidSummary.setTotalCases(96002.0);
        mockStateCovidSummary.setTotalDeaths(454.0);
        mockStateCovidSummary.setTotalRecovered(70082.0);

        when(service.save(Mockito.any(StateCovidSummary.class))).thenReturn(mockStateCovidSummary);

        String exampleStateCovidSummaryJson = "{\"state\":\"Alaska\",\"totalCases\":96002.0,\"totalDeaths\":454.0,\"totalRecovered\":70082.0,\"activeCases\":25466.0,\"totalCasesPerOneMilPopulation\":131232.0,\"deathPerOneMilPopulation\":621.0,\"totalTests\":2921249.0,\"testsPerOneMilPopulation\":3993259.0,\"population\":731545.0}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/summary")
                .accept(MediaType.APPLICATION_JSON)
                .content(exampleStateCovidSummaryJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(mvcResult.getResponse());

        assertEquals(HttpStatus.CREATED.value(), mvcResult.getResponse().getStatus());
        assertEquals("http://localhost/api/v1/summary",
                mvcResult.getResponse().getHeader(HttpHeaders.LOCATION));
    }
}
