package com.company.musicstorerecommendations.service;

import com.company.musicstorerecommendations.Repository.ArtistRecommendationRepository;
import com.company.musicstorerecommendations.model.ArtistRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ArtistRecommendationService {
    private final ArtistRecommendationRepository artistRecommendationRepository;

    @Autowired
    public ArtistRecommendationService(ArtistRecommendationRepository artistRecommendationRepository) {
        this.artistRecommendationRepository = artistRecommendationRepository;
    }

    public List<ArtistRecommendation> findAllArtistRecommendation() {
        return artistRecommendationRepository.findAll();
    }

    public ArtistRecommendation findById(Long id) {
        Optional<ArtistRecommendation> artistRecommendation = artistRecommendationRepository.findById((Long) id);

        if (artistRecommendation.isPresent()) {
            return artistRecommendation.get();
        } else throw new RuntimeException("artist Recommendation with this ID does not exist");
    }

    public ArtistRecommendation createArtistRecommendation(ArtistRecommendation newArtistRecommendation) {
        return artistRecommendationRepository.save(newArtistRecommendation);
    }

    public ArtistRecommendation updateArtistRecommendation(ArtistRecommendation artistRecommendation) {

        Optional<ArtistRecommendation> oldArtistRecommendation = artistRecommendationRepository.findById(artistRecommendation.getId());
        if (oldArtistRecommendation.isPresent()) {
            artistRecommendation.setId(oldArtistRecommendation.get().getId());
            return artistRecommendationRepository.save(artistRecommendation);
        } else throw new RuntimeException("artist Recommendation with that ID does not exist");
    }

    public void deleteArtistRecommendationById(Long id) {
        artistRecommendationRepository.deleteById((Long) id);
    }
}
