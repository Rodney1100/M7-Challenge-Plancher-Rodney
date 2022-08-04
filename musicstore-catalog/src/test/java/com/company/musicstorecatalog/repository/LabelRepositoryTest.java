package com.company.musicstorecatalog.repository;

import com.company.musicstorecatalog.model.Label;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LabelRepositoryTest {

    @Autowired
    private LabelRepository repo;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldShouldInteractWithDatabaseTable() {
//        Arrange
//        Make a new label
        Label label = new Label("Murda Ink", "www.MurdaInk.com");
        Label expectedLabel = new Label("Murda Ink", "www.MurdaInk.com");
//        Act
        label = repo.save(label);
        expectedLabel.setId(label.getId());
//        Assert
        assertEquals(expectedLabel,label);
    }

}