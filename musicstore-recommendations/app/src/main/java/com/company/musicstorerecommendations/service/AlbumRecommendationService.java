package com.company.musicstorerecommendations.service;
import com.company.musicstorerecommendations.Repository.AlbumRecommendationRepository;
import com.company.musicstorerecommendations.model.AlbumRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AlbumRecommendationService {
    private final AlbumRecommendationRepository albumRecommendationRepository;

    @Autowired
    public AlbumRecommendationService(AlbumRecommendationRepository AlbumRecommendationRepository) {
        this.albumRecommendationRepository = AlbumRecommendationRepository;
    }

    public List<AlbumRecommendation> findAllAlbumRecommendation() {
        return albumRecommendationRepository.findAll();
    }

    public AlbumRecommendation findById(Long id) {
        Optional<AlbumRecommendation> albumRecommendation = albumRecommendationRepository.findById((Long) id);

        if (albumRecommendation.isPresent()) {
            return albumRecommendation.get();
        } else throw new RuntimeException("Album Recommendation with this ID does not exist");
    }

    public AlbumRecommendation createAlbumRecommendation(AlbumRecommendation newAlbumRecommendation) {
        return albumRecommendationRepository.save(newAlbumRecommendation);
    }

    public AlbumRecommendation updateAlbumRecommendation(AlbumRecommendation AlbumRecommendation) {

        Optional<AlbumRecommendation> oldAlbumRecommendation = albumRecommendationRepository.findById(AlbumRecommendation.getId());
        if (oldAlbumRecommendation.isPresent()) {
            AlbumRecommendation.setId(oldAlbumRecommendation.get().getId());
            return albumRecommendationRepository.save(AlbumRecommendation);
        } else throw new RuntimeException("Album Recommendation with that ID does not exist");
    }

    public void deleteAlbumRecommendationById(Long id) {
        albumRecommendationRepository.deleteById((Long) id);
    }
}
