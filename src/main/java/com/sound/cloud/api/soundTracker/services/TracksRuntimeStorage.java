package com.sound.cloud.api.soundTracker.services;

import com.sound.cloud.api.soundTracker.model.Track;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

@Repository
public class TracksRuntimeStorage {

    private HashMap<String, ArrayList<Track>> tracksMap = new HashMap<>();

    public void addTracks(String band, ArrayList<Track> tracks) {
        this.tracksMap.put(band, tracks);
    }

    public ArrayList<Track> getTracksByBand(String band) {
        return this.tracksMap.get(band);
    }

    public ArrayList<Track> getAllTracks() {
        if (this.tracksMap.size() == 0) {
            return new ArrayList<>();
        }
        ArrayList<Track> tracks = new ArrayList<>();
        Comparator<Track> titleComparator = (Track one, Track two) -> one.getTitle().compareToIgnoreCase(two.getTitle());
        this.tracksMap.forEach((s, tracks1) -> {
            tracks.addAll(tracks1);
        });
        Collections.sort(tracks, titleComparator);
        return tracks;
    }

}
