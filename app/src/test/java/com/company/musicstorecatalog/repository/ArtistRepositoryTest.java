package com.company.musicstorecatalog.repository;

import com.company.musicstorecatalog.model.Artist;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtistRepositoryTest {

    @Autowired
    private ArtistRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void shouldShouldInteractWithDatabaseTable() {
//        Arrange
//        Make a new label
        Artist artist = new Artist("JZ", "@JZ", "@JayZ");
        Artist expectedLabel = new Artist("JZ", "@JZ", "@JayZ");

//        Act
        repo.save(artist);
        expectedLabel.setId(artist.getId());
        assertEquals(expectedLabel.toString(), artist.toString());

        // Act
        List<Artist> allTheArtist = repo.findAll();

        // Assert
        assertEquals(1, allTheArtist.size());

        // Act
        repo.deleteById(artist.getId());

        allTheArtist = repo.findAll();
        assertEquals(0, allTheArtist.size());
    }
}