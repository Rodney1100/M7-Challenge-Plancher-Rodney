package com.company.musicstorecatalog.service;

import com.company.musicstorecatalog.model.Label;
import com.company.musicstorecatalog.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class LabelService {

    private final LabelRepository labelRepository;

    @Autowired
    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public List<Label> findAllLabel() {
        return labelRepository.findAll();
    }

    public Label findById(long id) {
        Optional<Label> label = labelRepository.findById((long) id);

        if (label.isPresent()) {
            return label.get();
        } else throw new RuntimeException("Label with this ID does not exist");
    }

    public Label createLabel(Label newLabel) {
        return labelRepository.save(newLabel);
    }

    public Label updateLabel(Label label) {

        Optional<Label> oldLabel = labelRepository.findById(label.getId());
        if (oldLabel.isPresent()) {
            label.setId(oldLabel.get().getId());
            return labelRepository.save(label);
        } else throw new RuntimeException("Label with that ID does not exist");
    }
    public void deleteLabelById(long id) {
        labelRepository.deleteById((long)id);
    }
}
