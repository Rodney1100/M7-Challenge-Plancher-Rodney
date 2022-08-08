package com.company.musicstorecatalog.repository;

import com.company.musicstorecatalog.model.Album;
import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.model.Label;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumRepositoryTest {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private LabelRepository labelRepository;

    @Before
    public void setUp() throws Exception {
        albumRepository.deleteAll();
    }

    @Test
    public void shouldShouldInteractWithDatabaseTable() {
//        Arrange
//        Make a new label
        Label label = new Label("Murder Inc", "www.MurderInc.com");
        labelRepository.save(label);
        Label expectedLabel = new Label(label.getId(), "Murder Inc", "www.MurderInc.com");

        Artist artist = new Artist("JayZ", "@JayZ", "@JayZ");
        artistRepository.save(artist);
        Artist expectedArtist = new Artist(artist.getId(),"JayZ", "@JayZ", "@JayZ");

        Album album = new Album("The Black Album", artist.getId(), LocalDate.of(2003, 11, 14), label.getId(), new BigDecimal("19.99"));
        albumRepository.save(album);
        Album expectedAlbum = new Album(album.getId(), "The Black Album", artist.getId(), LocalDate.of(2003, 11, 14), label.getId(), new BigDecimal("19.99"));

        assertEquals(expectedAlbum.toString(), album.toString());

        // Act
        List<Album> allTheAlbum = albumRepository.findAll();

        // Assert
        assertEquals(1, allTheAlbum.size());

        // Act
        albumRepository.deleteById(album.getId());

        allTheAlbum = albumRepository.findAll();
        assertEquals(0, allTheAlbum.size());
    }
}