package com.sound.cloud.api.soundTracker.services;
import com.sound.cloud.api.soundTracker.model.Track;
import com.sound.cloud.api.soundTracker.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        Track toDelete = null;
        for (Track track : tracks) {
            toDelete = track;
            this.trackRepository.delete(track);
        }
        if (toDelete != null) {
            tracks.remove(toDelete);
        }
    }

    public void addNewTrack(Track track) {
        this.trackRepository.save(track);
    }

    public void deleteTrackById(Long id) {
        Optional<Track> track = this.trackRepository.findById(id);
        ArrayList<Track> tracks = this.tacksRuntimeStorage.getAllTracks();
        tracks.remove(track.get());
        this.trackRepository.deleteById(id);
    }


}
