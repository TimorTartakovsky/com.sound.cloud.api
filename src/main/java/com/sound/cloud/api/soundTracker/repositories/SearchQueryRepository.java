package com.sound.cloud.api.soundTracker.repositories;

import com.sound.cloud.api.soundTracker.model.SearchQuery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("SearchQueryRepository")
public interface SearchQueryRepository extends CrudRepository<SearchQuery, Long> {
}
