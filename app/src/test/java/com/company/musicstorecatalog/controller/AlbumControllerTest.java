package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.model.Label;
import com.company.musicstorecatalog.service.AlbumService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.company.musicstorecatalog.model.Album;
import com.company.musicstorecatalog.repository.AlbumRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AlbumController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AlbumControllerTest {
    @MockBean
    private AlbumService service;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    MockMvc mockMvc;
    @Before
    public void setUp() throws Exception {
        setUpAlbumServiceMock();
    }

    private void setUpAlbumServiceMock() {
        Album album1 = new Album(1L, "The Black Album", 10L, LocalDate.of(2003, 11, 14), 2L, new BigDecimal("19.99"));
        Album album2 = new Album( "The Black Album 2", 1L, LocalDate.of(2003, 11, 15), 20, new BigDecimal("19.99"));
        List<Album> albumList = Arrays.asList(album1, album2);
        doReturn(albumList).when(service).findAllAlbum();
        doReturn(album1).when(service).createAlbum(album2);
    }

//    @Test
//    public void getAllAlbum() throws Exception {
//        //Arrange
//        Album album1 = new Album("The Black Album", 10L, LocalDate.of(2003, 11, 14), 2L, new BigDecimal("19.99"));
//        Album album2 = new Album(1L,"The Black Album 2", 1L, LocalDate.of(2003, 11, 15), 20L, new BigDecimal("19.99"));
//
//        List<Album> albumList = Arrays.asList(album1, album2);
//        String expectedJsonValue =mapper.writeValueAsString(albumList);
////        doReturn(albumList).when(service).findAllAlbum();
//        mockMvc.perform(MockMvcRequestBuilders.get("/album"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(expectedJsonValue));
//    }

    //    @Test
//    public void createLabel() throws Exception {
//        Label labelIn = new Label(1L, "orange", "orange.com");
//        Label labelOut = new Label("Murder Ink", "MurderInk.com");
//        String labelInJson = mapper.writeValueAsString(labelIn);
//        String labelOutJson = mapper.writeValueAsString(labelOut);
//
//        mockMvc.perform(post("/label")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(labelInJson))
//                .andDo(print())
//                .andExpect(status().isCreated())            // Assert
//                .andExpect(content().json(labelOutJson));  // Assert
//    }

    @Test
    public void getOneAlbum() throws Exception {
        Album album = new Album(1L, "The Black Album", 10L, LocalDate.of(2003, 11, 14), 2L, new BigDecimal("19.99"));
        String expectedJsonValue = mapper.writeValueAsString(album);

        doReturn(album).when(service).findById((Long) 1L);

        ResultActions result = mockMvc.perform(get("/album/1"))
                .andExpect(status().isOk())
                .andExpect((content()
                        .json(expectedJsonValue)));
    }

    @Test
    public void shouldUpdateById() throws Exception {
        Album album = new Album(1L, "The Black Album", 10L, LocalDate.of(2003, 11, 14), 2L, new BigDecimal("19.99"));
        String expectedJsonValue = mapper.writeValueAsString(album);

        mockMvc.perform(put("/album/1")
                .content(expectedJsonValue)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteById() throws Exception {
        Album album = new Album(1L, "The Black Album", 10L, LocalDate.of(2003, 11, 14), 2L, new BigDecimal("19.99"));
        mockMvc.perform(delete("/album/1")).andExpect(status().isOk());
    }

}