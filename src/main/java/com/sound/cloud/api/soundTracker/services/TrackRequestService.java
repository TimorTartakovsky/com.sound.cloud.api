package com.sound.cloud.api.soundTracker.services;
import com.sound.cloud.api.soundTracker.model.Track;
import com.sound.cloud.api.soundTracker.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("TrackRequestService")
public class TrackRequestService {

    @Autowired
    private TrackRepository trackRepository;

    public ArrayList<Track> getAllTracks() {
        ArrayList<Track> tracks = new ArrayList<>();
        this.trackRepository.findAll().iterator().forEachRemaining(track -> tracks.add(track));
        return tracks;
    }


}
