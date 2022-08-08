//package com.company.musicstorecatalog.repository;
//
//import com.company.musicstorecatalog.model.Album;
//import com.company.musicstorecatalog.model.Artist;
//import com.company.musicstorecatalog.model.Label;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class AlbumRepositoryTest {
//    @Autowired
//    private AlbumRepository albumRepository;
//    @Autowired
//    private ArtistRepository artistRepository;
//    @Autowired
//    private LabelRepository labelRepository;
//
//    @Before
//    public void setUp() throws Exception {
////        repo.deleteAll();
//    }
//
//    @Test
//    public void shouldShouldInteractWithDatabaseTable() {
////        Arrange
////        Make a new label
//        Label label1 =new Label("label","label@i.com");
//        Label expectedLabel =new Label(1L,"label","label@i.com");
//        labelRepository.save(label1);
//        Artist artist =new Artist("JayZ", "@JayZ","@JayZ");
//        Artist expectedArtist =new Artist(1L,"JayZ", "@JayZ","@JayZ");
//        artistRepository.save(artist);
//        Album album = new Album("The Black Album", 1L, LocalDate.of(2003, 11, 14), 2L, new BigDecimal("19.99"));
//        Album expectedAlbum = new Album(1L,"The Black Album", 1L, LocalDate.of(2003, 11, 14), 2L, new BigDecimal("19.99"));
//        albumRepository.save(album);
//    }
//
//    @Test
//    public void shouldInteractWithDatabase(){
//        Label label1 =new Label("label","label@i.com");
//        Label expectedLabel =new Label(1L,"label","label@i.com");
//        labelRepository.save(label1);
//        Artist artist =new Artist("JayZ", "@JayZ","@JayZ");
//        Artist expectedArtist =new Artist(1L,"JayZ", "@JayZ","@JayZ");
//        artistRepository.save(artist);
//        Album album = new Album("The Black Album", 1L, LocalDate.of(2003, 11, 14), 2L, new BigDecimal("19.99"));
//        Album expectedAlbum = new Album(1L,"The Black Album", 1L, LocalDate.of(2003, 11, 14), 2L, new BigDecimal("19.99"));
//        albumRepository.save(album);
//        expectedAlbum.setId(album.getId());
//        assertEquals(expectedAlbum, album);
//
//        // Act
//        List<Album> allTheAlbum = albumRepository.findAll();
//
//        // Assert
//        assertEquals(1, allTheAlbum.size());
//
//        // Act
////        albumRepository.deleteById(album.getId());
//
//        allTheAlbum = albumRepository.findAll();
//        assertEquals(0, allTheAlbum.size());
//    }
//}