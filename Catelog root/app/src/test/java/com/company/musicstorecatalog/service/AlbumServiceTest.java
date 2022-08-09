package com.company.musicstorecatalog.service;

import com.company.musicstorecatalog.model.Album;
import com.company.musicstorecatalog.repository.AlbumRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class AlbumServiceTest {
    private AlbumService service;
    private AlbumRepository repo;

    @Before
    public void setUp() throws Exception {
        setUpAlbumRepositoryMock();
        this.service = new AlbumService(repo);
    }

    private void setUpAlbumRepositoryMock() {
        this.repo = mock(AlbumRepository.class);

        Album album = new Album("The Black Album",1L, LocalDate.of(2003, 11, 14), 1L, new BigDecimal("19.99"));
        Album album1 = new Album(album.getId(),"The Black Album",1L, LocalDate.of(2003, 11, 14), 1L, new BigDecimal("19.99"));

        List<Album> albumList = Collections.singletonList(album);

        Optional<Album> findByIdResult = Optional.of(album1);

        Mockito.when(repo.save(album)).thenReturn(album1);
        Mockito.when(repo.findAll()).thenReturn(albumList);
        Mockito.when(repo.findById(1L)).thenReturn(findByIdResult);
    }

    @Test
    public void addLabelShouldReturnLabelWithIdWhenSaving() {
//        Arrange
//        Make a new label
        Album album = new Album("The Black Album",1L, LocalDate.of(2003, 11, 14), 1L, new BigDecimal("19.99"));
        Album expectedAlbum = new Album(album.getId(),"The Black Album",1L, LocalDate.of(2003, 11, 14), 1L, new BigDecimal("19.99"));
//        Act
        Album actualAlbum = service.createAlbum(album);
//        Assert
        assertEquals(expectedAlbum.toString(), actualAlbum.toString());
    }
}