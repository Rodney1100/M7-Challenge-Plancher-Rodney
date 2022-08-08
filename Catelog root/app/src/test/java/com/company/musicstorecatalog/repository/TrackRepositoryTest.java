package com.company.musicstorecatalog.repository;

import com.company.musicstorecatalog.model.Album;
import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.model.Label;
import com.company.musicstorecatalog.model.Track;
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
public class TrackRepositoryTest {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private LabelRepository labelRepository;
    @Autowired
    private TrackRepository repo;
    @Autowired
    private AlbumRepository albumRepository;
    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
        albumRepository.deleteAll();
        labelRepository.deleteAll();
        artistRepository.deleteAll();
    }

    @Test
    public void shouldShouldInteractWithDatabaseTable() {
//        Arrange
        Label label = new Label("Murder Inc", "www.MurderInc.com");
        labelRepository.save(label);
        Label expectedLabel = new Label(label.getId(), "Murder Inc", "www.MurderInc.com");

        Artist artist = new Artist("JayZ", "@JayZ", "@JayZ");
        artistRepository.save(artist);
        Artist expectedArtist = new Artist(artist.getId(),"JayZ", "@JayZ", "@JayZ");

        Album album = new Album("The Black Album", artist.getId(), LocalDate.of(2003, 11, 14), label.getId(), new BigDecimal("19.99"));
        albumRepository.save(album);
        Album expectedAlbum = new Album(album.getId(), "The Black Album", artist.getId(), LocalDate.of(2003, 11, 14), label.getId(), new BigDecimal("19.99"));

//        Make a new label
        Track track = new Track(album.getId(), "99 Problems","358");
        repo.save(track);
        Track expectedTrack = new Track(track.getId(), album.getId(), "99 Problems","358");


//        Act
        expectedTrack.setId(track.getId());
        assertEquals(expectedTrack.toString(), track.toString());

        // Act
        List<Track> allTheTrack = repo.findAll();

        // Assert
        assertEquals(1, allTheTrack.size());

        // Act
        repo.deleteById(track.getId());

        allTheTrack = repo.findAll();
        assertEquals(0, allTheTrack.size());
    }
}