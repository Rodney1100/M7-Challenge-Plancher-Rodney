//package com.company.musicstorecatalog.repository;
//
//import com.company.musicstorecatalog.model.Track;
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
//public class TrackRepositoryTest {
//    @Autowired
//    private TrackRepository repo;
//
//    @Before
//    public void setUp() throws Exception {
//        repo.deleteAll();
//    }
//
//    @Test
//    public void shouldShouldInteractWithDatabaseTable() {
////        Arrange
////        Make a new label
//        Track track = new Track(1L,"99 Problems","358");
//        Track expectedTrack = new Track(1L,"99 Problems","358");
//
//
////        Act
//        repo.save(track);
//        expectedTrack.setId(track.getId());
//        assertEquals(expectedTrack.toString(), track.toString());
//
//        // Act
//        List<Track> allTheTrack = repo.findAll();
//
//        // Assert
//        assertEquals(1, allTheTrack.size());
//
//        // Act
//        repo.deleteById(track.getId());
//
//        allTheTrack = repo.findAll();
//        assertEquals(0, allTheTrack.size());
//    }
//}