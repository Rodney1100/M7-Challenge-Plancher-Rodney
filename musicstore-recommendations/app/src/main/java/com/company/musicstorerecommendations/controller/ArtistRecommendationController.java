package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.ArtistRecommendation;
import com.company.musicstorerecommendations.service.ArtistRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/artistRecommendation")
public class ArtistRecommendationController {
        @Autowired
        ArtistRecommendationService artistRecommendationService;
        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<ArtistRecommendation> getArtistRecommendationService() {
            return artistRecommendationService.findAllArtistRecommendation();
        }

        @GetMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public ArtistRecommendation getArtistRecommendationById(@PathVariable("id") Long id) {
            return artistRecommendationService.findById(id);
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public ArtistRecommendation createArtistRecommendation(@RequestBody @Valid ArtistRecommendation artistRecommendation) {
            return artistRecommendationService.createArtistRecommendation(artistRecommendation);
        }

        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public ArtistRecommendation updateArtistRecommendation(@RequestBody @Valid ArtistRecommendation artistRecommendation) {
            return artistRecommendationService.updateArtistRecommendation(artistRecommendation);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteArtistRecommendationById(@PathVariable Long id) {
           artistRecommendationService.deleteArtistRecommendationById(id);
        }
}
