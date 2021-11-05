package com.vengateshm.CovidDashboard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DashBoardControllerAcceptanceTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldGetDashBoardSummary() throws Exception {
        String expectedJsonContent = "{\"totalStates\":50,\"totalCases\":41761664,\"totalDeaths\":669723,\"totalRecovered\":28931205,\"totalActiveCases\":6620393,\"totalTests\":607393651,\"totalPopulation\":327533774}";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/summary/dashBoard"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJsonContent, false));
    }
}
