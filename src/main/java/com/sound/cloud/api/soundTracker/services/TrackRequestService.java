package com.sound.cloud.api.soundTracker.services;
import com.sound.cloud.api.soundTracker.model.Track;
import com.sound.cloud.api.soundTracker.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("TrackRequestService")
public class TrackRequestService {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private TracksRuntimeStorage tacksRuntimeStorage;

    public ArrayList<Track> getAllTracks() {
        ArrayList<Track> tracks = new ArrayList<>();
        this.trackRepository.findAll().iterator().forEachRemaining(track -> tracks.add(track));
        return tracks;
    }

    public void deleteTrackByPermalink(String permalink) {
        ArrayList<Track> tracks = this.tacksRuntimeStorage.getAllTracks();
        tracks.forEach(track -> {
            if (track.getPermalinkUrl() == permalink) {
                this.trackRepository.delete(track);
            }
        });
    }

    public void addNewTrack(Track track) {
        this.trackRepository.save(track);
    }

    public void deleteTrackById(Long id) {
        this.trackRepository.deleteById(id);
    }


}
