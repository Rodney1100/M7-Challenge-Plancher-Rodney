package com.company.musicstorerecommendations.Repository;

import com.company.musicstorerecommendations.model.LabelRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRecommendationRepository extends JpaRepository<LabelRecommendation, Integer> {
}
