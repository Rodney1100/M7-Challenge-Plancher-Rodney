package com.company.musicstorerecommendations.service;

import com.company.musicstorerecommendations.Repository.TrackRecommendationRepository;
import com.company.musicstorerecommendations.model.TrackRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TrackRecommendationService {
    private final TrackRecommendationRepository trackRecommendationRepository;

    @Autowired
    public TrackRecommendationService(TrackRecommendationRepository trackRecommendationRepository) {
        this.trackRecommendationRepository = trackRecommendationRepository;
    }

    public List<TrackRecommendation> findAllTrackRecommendation() {
        return trackRecommendationRepository.findAll();
    }

    public TrackRecommendation findById(Long id) {
        Optional<TrackRecommendation> trackRecommendation = trackRecommendationRepository.findById((Long) id);

        if (trackRecommendation.isPresent()) {
            return trackRecommendation.get();
        } else throw new RuntimeException("Track Recommendation with this ID does not exist");
    }

    public TrackRecommendation createTrackRecommendation(TrackRecommendation newTrackRecommendation) {
        return trackRecommendationRepository.save(newTrackRecommendation);
    }

    public TrackRecommendation updateTrackRecommendation(TrackRecommendation trackRecommendation) {

        Optional<TrackRecommendation> oldTrackRecommendation = trackRecommendationRepository.findById(trackRecommendation.getId());
        if (oldTrackRecommendation.isPresent()) {
            trackRecommendation.setId(oldTrackRecommendation.get().getId());
            return trackRecommendationRepository.save(trackRecommendation);
        } else throw new RuntimeException("Track Recommendation with that ID does not exist");
    }

    public void deleteTrackRecommendationById(Long id) {
        trackRecommendationRepository.deleteById((Long) id);
    }
}
