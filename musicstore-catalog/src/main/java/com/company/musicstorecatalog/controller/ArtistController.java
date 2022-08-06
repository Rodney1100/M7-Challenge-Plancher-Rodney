package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Artist getArtistById(@PathVariable("id") long id) {
        return artistService.findById((long) id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Artist createArtists(@RequestBody @Valid Artist artist) {
        if (artist.getName() == null) throw new RuntimeException("Artist must have a name");
        if (artist.getInstagram() == null) throw new RuntimeException("Artist must have a Website");
        if (artist.getTwitter() == null) throw new RuntimeException("Artist must have a Website");
        return artistService.createArtist(artist);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public Artist updateArtist(@RequestBody Artist artist, @PathVariable long id) {
    public Artist updateArtist(@RequestBody Artist artist) {
        if (artist.getName() == null) throw new RuntimeException("Artist must have a name");
        if (artist.getInstagram() == null) throw new RuntimeException("Artist must have a Website");
        if (artist.getTwitter() == null) throw new RuntimeException("Artist must have a Website");
        return artistService.updateArtist(artist);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteArtist(@PathVariable long id) {
        artistService.deleteArtistById((long) id);
    }

}
