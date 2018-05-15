package com.sound.cloud.api.soundTracker.components;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.sound.cloud.api.soundTracker.interfaces.ISoundCloudApiIntegration;
import com.sound.cloud.api.soundTracker.model.SearchQuery;
import com.sound.cloud.api.soundTracker.model.Track;
import com.sound.cloud.api.soundTracker.model.User;
import com.sound.cloud.api.soundTracker.repositories.SearchQueryRepository;
import com.sound.cloud.api.soundTracker.repositories.TrackRepository;
import com.sound.cloud.api.soundTracker.repositories.UserRepository;
import com.sound.cloud.api.soundTracker.services.TracksRuntimeStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;

@Component
@Scope("prototype")
public class ThreadBasedComponent implements Runnable, ISoundCloudApiIntegration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadBasedComponent.class);

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TracksRuntimeStorage tracksRuntimeStorage;

    @Autowired
    private SearchQueryRepository searchQueryRepository;

    private String trackName;

    @Override
    public void run() {
        LOGGER.info("====== Thread started request for" + this.trackName + "======");
        ArrayList<LinkedTreeMap<String, String>> tracksArray = initTracks();
        ArrayList<Track> tracks = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        tracksArray.forEach(tracksObject -> {
            Track newTrack = new Track(tracksObject.get("title"), tracksObject.get("permalink_url"));
            User newUser = new User(tracksObject.get("avatar_url"),
                    tracksObject.get("kind"),
                    tracksObject.get("permalink_url"),
                    tracksObject.get("uri"),
                    tracksObject.get("username"),
                    tracksObject.get("permalink"),
                    tracksObject.get("last_modified"));
            users.add(newUser);
            newTrack.getUsers().add(newUser);
            tracks.add(newTrack);
        });
        this.tracksRuntimeStorage.addTracks(this.trackName, tracks);
        this.userRepository.saveAll(users);
        this.trackRepository.saveAll(tracks);
        LOGGER.info("====== Thread finished request for" + this.trackName + "======");
    }

    @Override
    public ArrayList<LinkedTreeMap<String, String>> initTracks() {
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_SOUND_CLOUD_URL + TRACKS + this.trackName + LIMIT + CLIENT_ID;
        String result = restTemplate.getForObject(url, String.class);
        SearchQuery searchQuesry = new SearchQuery(url, new Timestamp(System.currentTimeMillis()));
        this.searchQueryRepository.save(searchQuesry);
        Gson googleJson = new Gson();
        ArrayList javaArrayListFromGSON = (ArrayList<LinkedTreeMap<String, String>>) googleJson.fromJson(result, ArrayList.class);
        return javaArrayListFromGSON;
    }

    public ThreadBasedComponent setTrackName(String trackName) {
        this.trackName = trackName;
        return this;
    }
}
