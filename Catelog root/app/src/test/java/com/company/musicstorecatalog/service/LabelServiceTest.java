package com.company.musicstorecatalog.service;

import com.company.musicstorecatalog.model.Label;
import com.company.musicstorecatalog.repository.LabelRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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

        Label labelIn = new Label("Murder Ink", "www.MurderInk.com");
        Label labelOut = new Label(1L, "Murder Ink", "www.MurderInk.com");

        List<Label> labelList = Arrays.asList(labelOut);

        Optional<Label> findByIdResult = Optional.of(labelOut);

//        Mockito.when(mainModel.getList()).thenReturn(someModelList);
        Mockito.when(repo.save(labelIn)).thenReturn(labelOut);
        Mockito.when(repo.findAll()).thenReturn(labelList);
        Mockito.when(repo.findById(1L)).thenReturn(findByIdResult);

//        doReturn(labelOut).when(repo).save(labelIn);
//        doReturn(labelList).when(repo).findAll();
//        doReturn(findByIdResult).when((repo).findById(1L));
    }

//    @Test
//    public void addLabelShouldReturnLabelWithIdWhenSaving() {
////        Arrange
////        Make a new label
//        Label labelToSave = new Label("Murder Ink", "www.MurderInk.com");
//        Label expectedLabel = new Label(1L,"Murder Ink", "www.MurderInk.com");
////        Act
//        Label actualLabel = service.createLabel(labelToSave);
////        Assert
//        assertEquals(expectedLabel.toString(), labelToSave.toString());
//    }

    @Test
    public void addLabelShouldReturnLabelWithIdWhenSaving() {
//        Arrange
//        Make a new label
        Label labelToSave = new Label("Murder Ink", "www.MurderInk.com");
        Label expectedLabel = new Label(1L, "Murder Ink", "www.MurderInk.com");
        expectedLabel.setId(labelToSave.getId());
//        Act
        Label actualLabel = service.createLabel(labelToSave);
//        Assert
        assertEquals(expectedLabel.toString(), labelToSave.toString());
    }
}