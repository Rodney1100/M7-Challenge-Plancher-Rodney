package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.model.Label;
import com.company.musicstorecatalog.service.LabelService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LabelController.class)
public class LabelControllerTest {

    @MockBean
    private LabelService service;
    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        setupLabelServiceMock();
    }

    private void setupLabelServiceMock() {
        Label label = new Label("Murder Ink", "MurderInk.com");
        Label label1 = new Label(1L, "Murder Ink", "MurderInk.com");
        List<Label> labelList = Collections.singletonList(label);
        doReturn(labelList).when(service).findAllLabel();
        doReturn(label1).when(service).createLabel(label1);
    }

    @Test
    public void getAllLabel() throws Exception {
        Label label = new Label("Murder Ink", "MurderInk.com");
        List<Label> labelList = Collections.singletonList(label);
        String expectedJsonValue = mapper.writeValueAsString(labelList);
        mockMvc.perform(get("/label"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJsonValue));
    }

    @Test
    public void createLabel() throws Exception {
        Label label = new Label("Murder Ink", "MurderInk.com");
        Label label2 = new Label(label.getId(), "orange", "orange.com");

        List<Label> labelList = Arrays.asList(label, label2);
        String expectedJsonValue = mapper.writeValueAsString(labelList);
        doReturn(labelList).when(service).findAllLabel();
        mockMvc.perform(MockMvcRequestBuilders.get("/label"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJsonValue));
    }

    @Test
    public void getOneLabel() throws Exception {
        Label label = new Label(1L, "Murder Ink", "MurderInk.com");
        String expectedJsonValue = mapper.writeValueAsString(label);

        doReturn(label).when(service).findById((Long) 1L);

        ResultActions result = mockMvc.perform(get("/label/1"))
                .andExpect(status().isOk())
                .andExpect((content()
                        .json(expectedJsonValue)));
    }

    @Test
    public void shouldUpdateById() throws Exception {
        Label label = new Label(1L, "Murder Ink", "MurderInk.com");
        String expectedJsonValue = mapper.writeValueAsString(label);

        mockMvc.perform(put("/label/1").content(expectedJsonValue).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteById() throws Exception {
        Label label = new Label(1L, "Murder Ink", "MurderInk.com");
        mockMvc.perform(delete("/label/1")).andExpect(status().isOk());
    }
}