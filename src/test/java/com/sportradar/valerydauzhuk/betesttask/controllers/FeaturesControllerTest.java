package com.sportradar.valerydauzhuk.betesttask.controllers;

import com.sportradar.valerydauzhuk.betesttask.service.CompetitorsNamesSortedAlphabetically;
import com.sportradar.valerydauzhuk.betesttask.service.MostProbableEventsResults;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = FeaturesController.class)
public class FeaturesControllerTest {

    private MockMvc mockMvc;

    @MockBean
    MostProbableEventsResults mostProbableEventsResults;

    @MockBean
    CompetitorsNamesSortedAlphabetically competitorsNamesSortedAlphabetically;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void contextLoad() {
        assertThat(webApplicationContext).isNotNull();
    }

    @Test
    public void resultsControllerStatusCheck() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/results?=10"))
                .andExpect(status().isOk());
    }

    @Test
    public void uniqueCompetitorsNamesStatusCheck() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/unique-competitors-names"))
                .andExpect(status().isOk());
    }

    @Test
    public void uniqueCompetitorsNamesForGivenCompetitionStatusCheck() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/UEFA%20Champions%20League/unique-competitors-names"))
                .andExpect(status().isOk());
    }
}