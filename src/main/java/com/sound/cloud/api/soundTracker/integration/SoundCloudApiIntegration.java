package com.sound.cloud.api.soundTracker.integration;

import com.sound.cloud.api.soundTracker.interfaces.ISoundCloudApiIntegration;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class SoundCloudApiIntegration implements ISoundCloudApiIntegration {

    @Override
    public List<?> initTracks() throws RestClientException {

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(BASE_SOUND_CLOUD_URL + TRACKS + "2PAC"+ CLIENT_ID, String.class);
        GsonJsonParser g = new GsonJsonParser();
        return g.parseList(result);
    }
}
