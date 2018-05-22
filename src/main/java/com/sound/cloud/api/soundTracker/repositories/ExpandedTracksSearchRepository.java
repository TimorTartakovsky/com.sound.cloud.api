package com.sound.cloud.api.soundTracker.repositories;

import com.sound.cloud.api.soundTracker.model.ExpandedSearchQuery;
import org.springframework.data.repository.CrudRepository;

public interface ExpandedTracksSearchRepository extends CrudRepository<ExpandedSearchQuery, Long> {
}
