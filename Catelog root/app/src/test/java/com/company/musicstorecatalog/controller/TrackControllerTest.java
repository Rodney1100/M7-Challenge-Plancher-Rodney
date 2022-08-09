package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.model.Track;
import com.company.musicstorecatalog.service.TrackService;
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
@WebMvcTest(TrackController.class)
public class TrackControllerTest {

    @MockBean
    private TrackService service;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        setUpTrackServiceMock();
    }

    public void setUpTrackServiceMock() {
        Track track = new Track(1L, "New York", "200");
        Track track1 = new Track(1L, 1L, "New York", "200");
        List<Track> trackList = Collections.singletonList(track);
        doReturn(trackList).when(service).findAllTrack();
        doReturn(track1).when(service).createTrack(track1);
    }

    @Test
    public void getAllTracks() throws Exception {
//        Album album1 = new Album("The Black Album", 10L, LocalDate.of(2003, 11, 14), 2L, new BigDecimal("19.99"));
        Track track = new Track(1L, "New York", "200");
        Track track1 = new Track(1L, 1L, "New York", "200");
        List<Track> trackList = Arrays.asList(track, track1);
        doReturn(trackList).when(service).findAllTrack();

        mockMvc.perform(MockMvcRequestBuilders.get("/track"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(trackList)));
    }

    @Test
    public void createTrack() throws Exception {
        Track track1 = new Track( 1L, "New York", "200");
        Track track2 = new Track(track1.getId(),1L, "New York", "200");

        mockMvc.perform(post("/track")
                        .content(mapper.writeValueAsString(track1))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(mapper.writeValueAsString(track2)));
    }

    @Test
    public void getOneTrack() throws Exception {
        Track track = new Track(1L, 1L, "New York", "200");
        String expectedJsonValue = mapper.writeValueAsString(track);

        doReturn(track).when(service).findTrackById((Long) 1L);

        ResultActions result = mockMvc.perform(get("/track/1"))
                .andExpect(status().isOk())
                .andExpect((content()
                        .json(expectedJsonValue)));
    }

    @Test
    public void shouldUpdateById() throws Exception {
        Track track = new Track(1L, "Murder Ink", "MurderInk.com");
        String expectedJsonValue = mapper.writeValueAsString(track);

        mockMvc.perform(put("/track/1").content(expectedJsonValue).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteById() throws Exception {
        Track track = new Track(1L, 1L, "New York", "200");
        mockMvc.perform(MockMvcRequestBuilders.delete("/track/1")).andExpect(status().isOk());
    }
}