package com.sound.cloud.api.soundTracker.repositories;

import com.sound.cloud.api.soundTracker.model.Track;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("TrackRepository")
public interface TrackRepository extends CrudRepository<Track, Long> {}
