package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.model.Album;
import com.company.musicstorecatalog.repository.AlbumRepository;
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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AlbumController.class)
public class AlbumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlbumRepository repo;

    @Autowired
    private ObjectMapper mapper;

    @Before
    public void setUp() throws Exception {
        setUpAlbumServiceMock();
    }

    private void setUpAlbumServiceMock() {
        Album album1 = new Album(1L, "The Black Album", 10, LocalDate.of(2003, 11, 14), 2, new BigDecimal(19.99));
        Album album2 = new Album(2L, "The Black Album 2", 1, LocalDate.of(2003, 11, 15), 20, new BigDecimal(19.99));
        List<Album> albumList = Arrays.asList(album1, album2);
        when(repo.findAll()).thenReturn(albumList);

    }

    @Test
    public void getAllAlbum() throws Exception {

        //Arrange
        Album album1 = new Album("The Black Album", 10, LocalDate.of(2003, 11, 14), 2, new BigDecimal(19.99));
        Album album2 = new Album("The Black Album 2", 1, LocalDate.of(2003, 11, 15), 20, new BigDecimal(19.99));
        List<Album> albumList = Arrays.asList(album1, album2);
        String expectedJsonValue = mapper.writeValueAsString(albumList);
//        Act
        mockMvc.perform(get("/album"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().json(mapper.writeValueAsString(expectedJsonValue)));
    }


}