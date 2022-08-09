package com.company.musicstorecatalog.service;

import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.repository.ArtistRepository;
import com.company.musicstorecatalog.repository.ArtistRepository;
import com.company.musicstorecatalog.repository.ArtistRepository;
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

public class ArtistServiceTest {

    private ArtistService service;
    private ArtistRepository repo;

    @Before
    public void setUp() throws Exception {
        setUpArtistRepositoryMock();
        this.service = new ArtistService(repo);
    }

    private void setUpArtistRepositoryMock() {
        this.repo = mock(ArtistRepository.class);

        Artist artist = new Artist("Rodney", "@rodney","@Rodney");
        Artist artist1 = new Artist(artist.getId(),"Rodney", "@rodney","@Rodney");


        List<Artist> artistList = Collections.singletonList(artist);

        Optional<Artist> findByIdResult = Optional.of(artist1);

        Mockito.when(repo.save(artist)).thenReturn(artist1);
        Mockito.when(repo.findAll()).thenReturn(artistList);
        Mockito.when(repo.findById(1L)).thenReturn(findByIdResult);
    }

    @Test
    public void addArtistShouldReturnLabelWithIdWhenSaving() {
//        Arrange
//        Make a new label

        Artist artist = new Artist("Rodney", "@rodney","@Rodney");
        Artist actualArtist1 = new Artist(artist.getId(),"Rodney", "@rodney","@Rodney");
//        Act
        Artist actualArtist = service.createArtist(artist);
//        Assert
        assertEquals(actualArtist.toString(), actualArtist1.toString());
    }
}