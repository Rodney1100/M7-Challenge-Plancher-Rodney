package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.model.Album;
import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.service.ArtistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ArtistControllerTest {
    @InjectMocks
    private ArtistService service;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        setUpArtistServiceMock();
    }

    private void setUpArtistServiceMock() {
        Artist artist1 = new Artist(1L,"Rodney", "@Rodney", "@Rodney");
        Artist artist2 = new Artist("Rodney", "@Rodney", "@Rodney");
        List<Artist> artistList = Arrays.asList(artist1, artist2);
        doReturn(artistList).when(service).findAllArtist();
        doReturn(artist1).when(service).createArtist(artist2);
    }

    @Test
    public void getAllArtist() throws Exception {
        //Arrange
        Artist artist1 = new Artist("Rodney", "@Rodney", "@Rodney");
        Artist artist2 = new Artist(1L, "Rodney", "@Rodney", "@Rodney");

        List<Artist> artistList = Arrays.asList(artist1,artist2);
        String expectedJsonValue = mapper.writeValueAsString(artistList);
        doReturn(artistList).when(service).findAllArtist();
        mockMvc.perform(MockMvcRequestBuilders.get("/artist"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJsonValue));
    }

    @Test
    public void createArtist() throws Exception {
        Artist artist = new Artist("Rodney", "@Rodney", "@Rodney");
        Artist artist2 =  new Artist(artist.getId(),"Rodney", "@Rodney", "@Rodney");
        mockMvc.perform(post("/artist")
                        .content(mapper.writeValueAsString(artist))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(mapper.writeValueAsString(artist2)));
    }

    @Test
    public void getOneArtist() throws Exception {
        Artist artist = new Artist(1L,"Rodney", "@Rodney", "@Rodney");
        String expectedJsonValue = mapper.writeValueAsString(artist);

        doReturn(artist).when(service).findById((Long) 1L);

        ResultActions result = mockMvc.perform(get("/artist/1"))
                .andExpect(status().isOk())
                .andExpect((content()
                        .json(expectedJsonValue)));
    }

    @Test
    public void shouldUpdateById() throws Exception {
        Artist artist = new Artist(1L,"Rodney", "@Rodney", "@Rodney");
        String expectedJsonValue = mapper.writeValueAsString(artist);

        mockMvc.perform(put("/artist/1")
                        .content(expectedJsonValue)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteById() throws Exception {
        Artist artist = new Artist(1L,"Rodney","@Rodney", "@Rodney");
        mockMvc.perform(delete("/artist/1")).andExpect(status().isOk());
    }
}