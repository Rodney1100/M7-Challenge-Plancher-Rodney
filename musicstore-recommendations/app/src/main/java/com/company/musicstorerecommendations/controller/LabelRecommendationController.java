package com.company.musicstorerecommendations.controller;


import com.company.musicstorerecommendations.model.LabelRecommendation;
import com.company.musicstorerecommendations.service.LabelRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/labelRecommendation")
public class LabelRecommendationController {
    @Autowired
    LabelRecommendationService labelRecommendationService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LabelRecommendation> getLabelRecommendationService() {
        return labelRecommendationService.findAllLabelRecommendation();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LabelRecommendation getLabelRecommendationById(@PathVariable("id") Long id) {
        return labelRecommendationService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public LabelRecommendation createLabelRecommendation(@RequestBody @Valid LabelRecommendation labelRecommendation) {
        return labelRecommendationService.createLabelRecommendation(labelRecommendation);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public LabelRecommendation updateLabelRecommendation(@RequestBody @Valid LabelRecommendation labelRecommendation) {
        return labelRecommendationService.updateLabelRecommendation(labelRecommendation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLabelRecommendationById(@PathVariable Long id) {
        labelRecommendationService.deleteLabelRecommendationById(id);
    }
}
