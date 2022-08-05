package com.company.musicstorecatalog.service;

import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> findAllArtist() {
        return artistRepository.findAll();
    }

    public Artist findById(long id) {
        Optional<Artist> artist = artistRepository.findById((long) id);

        if (artist.isPresent()) {
            return artist.get();
        } else throw new RuntimeException("Artist with this ID does not exist");
    }

    public Artist createArtist(Artist newArtist) {
        return artistRepository.save(newArtist);
    }

    public Artist updateArtist(Artist artist) {

        Optional<Artist> oldArtist = artistRepository.findById(artist.getId());
        if (oldArtist.isPresent()) {
            artist.setId(oldArtist.get().getId());
            return artistRepository.save(artist);
        } else throw new RuntimeException("Aritst with that ID does not exist");
    }

    public void deleteArtistById(long id) {
        artistRepository.deleteById((long) id);
    }
}
