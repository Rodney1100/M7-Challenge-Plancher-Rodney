package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.TrackRecommendation;
import com.company.musicstorerecommendations.service.TrackRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/trackRecommendation")
public class TrackRecommendationController {
    @Autowired
    TrackRecommendationService trackRecommendationService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TrackRecommendation> getTrackRecommendationService() {
        return trackRecommendationService.findAllTrackRecommendation();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrackRecommendation getTrackRecommendationById(@PathVariable("id") Long id) {
        return trackRecommendationService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TrackRecommendation createTrackRecommendation(@RequestBody @Valid TrackRecommendation trackRecommendation) {
        return trackRecommendationService.createTrackRecommendation(trackRecommendation);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TrackRecommendation updateTrackRecommendation(@RequestBody @Valid TrackRecommendation trackRecommendation) {
        return trackRecommendationService.updateTrackRecommendation(trackRecommendation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrackRecommendationById(@PathVariable Long id) {
        trackRecommendationService.deleteTrackRecommendationById(id);
    }
}
