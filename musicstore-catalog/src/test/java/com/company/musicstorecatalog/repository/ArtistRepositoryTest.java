package com.company.musicstorecatalog.repository;

import com.company.musicstorecatalog.model.Artist;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ArtistRepositoryTest {

    @Autowired
    private ArtistRepository repo;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldShouldInteractWithDatabaseTable() {
        Artist artist = new Artist("JZ", "@JZ", "@JayZ");
        Artist expectedLabel = new Artist("JZ", "@JZ", "@JayZ");
        repo.save(artist);
        expectedLabel.setId(artist.getId());
        assertEquals(expectedLabel, artist);

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