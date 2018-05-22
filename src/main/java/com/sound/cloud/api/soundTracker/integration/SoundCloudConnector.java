package com.sound.cloud.api.soundTracker.integration;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.sound.cloud.api.soundTracker.interfaces.IConnector;
import com.sound.cloud.api.soundTracker.model.ExpandedSearchQuery;
import com.sound.cloud.api.soundTracker.repositories.ExpandedTracksSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;

@Repository("SoundCloudConnector")
public class SoundCloudConnector implements IConnector {

    private RestTemplate restTemplate;

    private ExpandedTracksSearchRepository expandedTracksSearchRepository;

    @Autowired
    public void setExpandedTracksSearchRepository(ExpandedTracksSearchRepository expandedTracksSearchRepository) {
        this.expandedTracksSearchRepository = expandedTracksSearchRepository;
    }

    public SoundCloudConnector() {
        restTemplate = new RestTemplate();
    }

    @Override
    public ArrayList<LinkedTreeMap<String, Object>> getTracksByBandName(String bandName) throws RestClientException {
        String url = BASE_SOUND_CLOUD_URL + TRACKS + bandName + LIMIT + CLIENT_ID;
        String result = restTemplate.getForObject(url, String.class);
        ExpandedSearchQuery searchQuesry = new ExpandedSearchQuery(bandName, result, new Timestamp(System.currentTimeMillis()));
        this.expandedTracksSearchRepository.save(searchQuesry);
        Gson googleJson = new Gson();
        ArrayList javaArrayListFromGSON = (ArrayList<LinkedTreeMap<String, Object>>) googleJson.fromJson(result, ArrayList.class);
        return javaArrayListFromGSON;
    }

    @Override
    public ArrayList<LinkedTreeMap<String, Object>> getTracksByBandNameAndUserId(String bandName, Integer userId) {
        return null;
    }

    @Override
    public ArrayList<LinkedTreeMap<String, String>> initTracks() {
        return null;
    }
}
