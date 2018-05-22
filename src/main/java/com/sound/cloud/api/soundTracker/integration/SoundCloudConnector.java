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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    /*
    * getTracksByBandName connects with Sound Cloud API and fetch all the tracks related to a band.
    * @Param String bandName
    * return ArrayList<LinkedTreeMap<String, Object>> or RestClientException
    * */
    @Override
    public ArrayList<LinkedTreeMap<String, Object>> getTracksByBandName(String bandName) throws RestClientException {
        String url = BASE_SOUND_CLOUD_URL + TRACKS + bandName + CLIENT_ID;
        String result = restTemplate.getForObject(url, String.class);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        try {
            String str = dateFormat.format(new Date());
            Date date = dateFormat.parse(str);
            ExpandedSearchQuery searchQuesry = new ExpandedSearchQuery(bandName, result, date);
            this.expandedTracksSearchRepository.save(searchQuesry);
        }
        catch (ParseException e) {}
        Gson googleJson = new Gson();
        ArrayList javaArrayListFromGSON = (ArrayList<LinkedTreeMap<String, Object>>) googleJson.fromJson(result, ArrayList.class);
        return javaArrayListFromGSON;
    }

    @Override
    public ArrayList<LinkedTreeMap<String, Object>> getTracksByBandNameAndUserId(String bandName, Integer userId) {
        return null;
    }

    @Override
    public ArrayList<LinkedTreeMap<String, Object>> initTracks() {
        return null;
    }
}
