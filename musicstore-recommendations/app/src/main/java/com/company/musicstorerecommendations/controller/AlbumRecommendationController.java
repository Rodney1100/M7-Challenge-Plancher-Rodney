package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.AlbumRecommendation;
import com.company.musicstorerecommendations.service.AlbumRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/albumRecommendation")
public class AlbumRecommendationController {
    @Autowired
    AlbumRecommendationService albumRecommendationService;
    @GetMapping

    @ResponseStatus(HttpStatus.OK)
    public List<AlbumRecommendation> getAlbumRecommendationService() {
        return albumRecommendationService.findAllAlbumRecommendation();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlbumRecommendation getAlbumRecommendationById(@PathVariable("id") Long id) {
        return albumRecommendationService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumRecommendation createAlbumRecommendation(@RequestBody @Valid AlbumRecommendation albumRecommendation) {
        return albumRecommendationService.createAlbumRecommendation(albumRecommendation);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public AlbumRecommendation updateAlbumRecommendation(@RequestBody @Valid AlbumRecommendation albumRecommendation) {
        return albumRecommendationService.updateAlbumRecommendation(albumRecommendation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbumRecommendationById(@PathVariable Long id) {
        albumRecommendationService.deleteAlbumRecommendationById(id);
    }
}
