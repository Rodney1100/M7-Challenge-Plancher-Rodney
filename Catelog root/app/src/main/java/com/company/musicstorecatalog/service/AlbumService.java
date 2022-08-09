package com.company.musicstorecatalog.service;


import com.company.musicstorecatalog.model.Album;
import com.company.musicstorecatalog.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> findAllAlbum() {
        return albumRepository.findAll();
    }

    public Album findById(Long id) {
        Optional<Album> album = albumRepository.findById((Long) id);

        if (album.isPresent()) {
            return album.get();
        } else throw new RuntimeException("Album with this ID does not exist");
    }

    public Album createAlbum(Album newAlbum) {
        newAlbum = albumRepository.save(newAlbum);
        return newAlbum;
    }

    public Album updateAlbum(Album album) {

        Optional<Album> oldAlbum = albumRepository.findById(album.getId());
        if (oldAlbum.isPresent()) {
            album.setId(oldAlbum.get().getId());
            return albumRepository.save(album);
        } else throw new RuntimeException("Album with that ID does not exist");
    }

    public void deleteAlbumById(long id) {
        albumRepository.deleteById(id);
    }
}
