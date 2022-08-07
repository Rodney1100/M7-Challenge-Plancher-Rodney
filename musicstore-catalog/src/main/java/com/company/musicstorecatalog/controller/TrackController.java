package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.model.Label;
import com.company.musicstorecatalog.model.Track;
import com.company.musicstorecatalog.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/track")
public class TrackController {

    @Autowired
    TrackService trackService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Track> getAllTrack() {
        return trackService.findAllTrack();
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Track getTrackById(@PathVariable("id") long id) {
        return trackService.findTrackById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Track createTrack(@RequestBody @Valid Track track) {
        if (track.getTitle() == null) throw new RuntimeException("Track must have a Title");
        if (track.getAlbumId() == 0) throw new RuntimeException("Track must have a Album ID");
        if (track.getRunTime() == null) throw new RuntimeException("Track must have a Run time");
        return trackService.createTrack(track);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Track updateTrack(@PathVariable long id, @RequestBody Track track) {
//    public Track updateTrack(@RequestBody Track track) {
        if (track.getTitle() == null) throw new RuntimeException("Track must have a title");

        if (track.getAlbumId() == 0) throw new IllegalArgumentException("Track must have a album ID");
        if (track.getRunTime() == null) throw new IllegalArgumentException("Track must have a Run time");

        return trackService.updateTrack(track);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTrack(@PathVariable long id) {
        trackService.deleteTrackById((long) id);
    }
}
