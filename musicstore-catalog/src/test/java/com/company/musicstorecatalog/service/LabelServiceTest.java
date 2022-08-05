package com.company.musicstorecatalog.service;

import com.company.musicstorecatalog.model.Label;
import com.company.musicstorecatalog.repository.LabelRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class LabelServiceTest {

    private LabelService service;
    private LabelRepository repo;

    @Before
    public void setUp() throws Exception {
        setUpLabelRepositoryMock();
        this.service = new LabelService(repo);
    }

    private void setUpLabelRepositoryMock() {
        this.repo = mock(LabelRepository.class);

        Label label = new Label("Murda Ink", "www.MurdaInk.com");
        Label expectedLabel = new Label(1L, "Murda Ink", "www.MurdaInk.com");

        List<Label> labelList = Arrays.asList(expectedLabel);

        Optional<Label> findByIdResult = Optional.of(expectedLabel);

        doReturn(expectedLabel).when(repo).save(label);
        doReturn(labelList).when(repo).findAll();
        doReturn(findByIdResult).when(repo).save(label);

    }

    @Test
    public void shouldReturnLabelWithIdWhenSaving() {
//        Arrange
//        Make a new label
        Label labelToSave = new Label("Murder Ink", "www.MurderInk.com");
        Label expectedLabel = new Label(1L,"Murder Ink", "www.MurderInk.com");
//        Act
        Label actualResult = service.addLabel(labelToSave);
//        Assert
        assertEquals(expectedLabel, actualResult);
    }

}