package com.company.musicstorecatalog.repository;

import com.company.musicstorecatalog.model.Album;
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
    private AlbumRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void shouldShouldInteractWithDatabaseTable() {
//        Arrange
//        Make a new label
        Album album= new Album  ("The Black Album", 100, LocalDate.of(2003,11 ,14), 2000, new BigDecimal(19.99));
        Album expectedAlbum= new Album  ("The Black Album", 100, LocalDate.of(2003,11,14), 2000, new BigDecimal(19.99));


//        Act
        repo.save(album);
        expectedAlbum.setId(album.getId());
        assertEquals(expectedAlbum.toString(), album.toString());

        // Act
        List<Album> allTheAlbum = repo.findAll();

        // Assert
        assertEquals(1, allTheAlbum.size());

        // Act
        repo.deleteById(album.getId());

        allTheAlbum = repo.findAll();
        assertEquals(0, allTheAlbum.size());
    }
}