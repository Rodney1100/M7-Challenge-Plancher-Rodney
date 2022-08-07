package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.model.Album;
import com.company.musicstorecatalog.model.Label;
import com.company.musicstorecatalog.service.LabelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class LabelControllerTest {

    @MockBean
    private LabelService service;

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        serUpLAbelServiceMock();
    }

    private void serUpLAbelServiceMock() {
        Label label = new Label(1L, "block inter", "blockInter.com");
        List<Label> labelList = Arrays.asList(label);

        when((service).findAllLabel()).thenReturn(labelList);
    }

    @Test
    public void getAllLabelShouldReturnAListOfAllLabels() throws Exception {

        //Arrange
        Label label = new Label(1L, "block inter", "blockInter.com");        List<Label> labelList = Collections.singletonList(label);
        String expectedJsonValue = mapper.writeValueAsString(labelList);
//        Act
        mockMvc.perform(get("/label"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().json(mapper.writeValueAsString(expectedJsonValue)));
    }

    }
