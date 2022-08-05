package com.company.musicstorecatalog.repository;

import com.company.musicstorecatalog.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository  extends JpaRepository<Track, Long> {
}
