package com.company.musicstorecatalog.controller;


import com.company.musicstorecatalog.model.Album;
import com.company.musicstorecatalog.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/album")
public class AlbumController {
    @Autowired
    AlbumService albumService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Album> getAllAlbum() {
       return albumService.findAllAlbum() ;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Album getAlbumById(@PathVariable("id") long id) {
        return albumService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Album createAlbum(@RequestBody @Valid Album album) {
        if (album.getTitle() == null) throw new RuntimeException("Album must have a name");
        if (album.getArtistId() == null) throw new RuntimeException("Label must have a Website");
        if (album.getReleaseDate() == null) throw new RuntimeException("Label must have a Website");
        if (album.getLabelId() == null) throw new RuntimeException("Label must have a Website");
        if (album.getListPrice() == null) throw new RuntimeException("Label must have a Website");
        return albumService.createAlbum(album);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Album updateAlbum(@RequestBody Album album) {
        if (album.getTitle() == null) throw new RuntimeException("Album must have a name");
        if (album.getArtistId() == null) throw new RuntimeException("Label must have a Website");
        if (album.getReleaseDate() == null) throw new RuntimeException("Label must have a Website");
        if (album.getLabelId() == null) throw new RuntimeException("Label must have a Website");
        if (album.getListPrice() == null) throw new RuntimeException("Label must have a Website");;
        return albumService.updateAlbum(album);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAlbum(@PathVariable long id) {
        albumService.deleteAlbumById((long) id);
    }
}
