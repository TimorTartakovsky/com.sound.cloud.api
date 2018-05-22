package com.sound.cloud.api.soundTracker.repositories;

import com.sound.cloud.api.soundTracker.model.ExpandedTrack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ExpandedTrackRepository")
public interface ExpandedTrackRepository extends CrudRepository<ExpandedTrack, Long> {}
