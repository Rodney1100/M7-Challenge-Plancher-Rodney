package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/artist")
@RestController
public class ArtistController {
    @Autowired
    ArtistService artistService;

    @RequestMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Artist> getAllArtist() {
        return artistService.findAllArtist();
    }

    @RequestMapping()
    @ResponseStatus(HttpStatus.OK)
    public Artist getArtistById(@PathVariable("id") long id) {
        return artistService.findById((long) id);
    }

}
