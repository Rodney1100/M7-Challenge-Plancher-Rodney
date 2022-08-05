package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.model.Label;
import com.company.musicstorecatalog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/label")
public class LabelController {

    @Autowired
    LabelService labelService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Label> getAllLabel() {
        return labelService.findAllLabel();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Label getLabelById(@PathVariable("id") long id) {
        return labelService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Label createLabel(@RequestBody @Valid Label label) {
        if (label.getName() == null) throw new RuntimeException("Label must have a name");
        if (label.getWebsite() == null) throw new RuntimeException("Label must have a Website");
        return label;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public Label updateLabel(@RequestBody Label label, @PathVariable long id) {
    public Label updateLabel(@RequestBody Label label) {
        if (label.getName() == null) throw new RuntimeException("Label must have a name");

        if (label.getWebsite() == null) throw new IllegalArgumentException("Label must have a Website");

        return labelService.updateLabel(label);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteLabel(@PathVariable long id) {
        labelService.deleteLabelById((long) id);
    }
}
