package com.company.musicstorerecommendations.service;

import com.company.musicstorerecommendations.Repository.LabelRecommendationRepository;
import com.company.musicstorerecommendations.model.LabelRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LabelRecommendationService {
    private final LabelRecommendationRepository labelRecommendationRepository;

    @Autowired
    public LabelRecommendationService(LabelRecommendationRepository labelRecommendationRepository) {
        this.labelRecommendationRepository = labelRecommendationRepository;
    }

    public List<LabelRecommendation> findAllLabelRecommendation() {
        return labelRecommendationRepository.findAll();
    }

    public LabelRecommendation findById(Long id) {
        Optional<LabelRecommendation> labelRecommendation = labelRecommendationRepository.findById((Long) id);

        if (labelRecommendation.isPresent()) {
            return labelRecommendation.get();
        } else throw new RuntimeException("Label Recommendation with this ID does not exist");
    }

    public LabelRecommendation createLabelRecommendation(LabelRecommendation newLabelRecommendation) {
        return labelRecommendationRepository.save(newLabelRecommendation);
    }

    public LabelRecommendation updateLabelRecommendation(LabelRecommendation labelRecommendation) {

        Optional<LabelRecommendation> oldLabelRecommendation = labelRecommendationRepository.findById(labelRecommendation.getId());
        if (oldLabelRecommendation.isPresent()) {
            labelRecommendation.setId(oldLabelRecommendation.get().getId());
            return labelRecommendationRepository.save(labelRecommendation);
        } else throw new RuntimeException("Label Recommendation with that ID does not exist");
    }

    public void deleteLabelRecommendationById(Long id) {
        labelRecommendationRepository.deleteById((Long) id);
    }
}
