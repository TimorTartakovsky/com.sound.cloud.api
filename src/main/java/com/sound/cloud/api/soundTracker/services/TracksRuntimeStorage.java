package com.sound.cloud.api.soundTracker.services;

import com.sound.cloud.api.soundTracker.model.ExpandedTrack;
import com.sound.cloud.api.soundTracker.model.Track;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

@Repository("TracksRuntimeStorage")
public class TracksRuntimeStorage {

    private HashMap<String, ArrayList<Track>> tracksMap = new HashMap<>();
    private HashMap<String, ArrayList<ExpandedTrack>> expandedTracksMap = new HashMap<>();

    public void addTracks(String url, ArrayList<Track> tracks) {
        this.tracksMap.put(url, tracks);
    }

    public void addExpandedTracks(String band, ArrayList<ExpandedTrack> tracks) {
        this.expandedTracksMap.put(band, tracks);
    }

    public ArrayList<Track> getTracksByBand(String url) {
        return this.tracksMap.get(url);
    }

    public ArrayList<ExpandedTrack> getExpandedTracksByBand(String band) {
        return this.expandedTracksMap.get(band);
    }

    public ArrayList<ExpandedTrack> getAllExpandedTracks() {
        if (this.expandedTracksMap.size() == 0) {
            return new ArrayList<>();
        }
        ArrayList<ExpandedTrack> tracks = new ArrayList<>();
        this.expandedTracksMap.forEach((s, track) -> {
            tracks.addAll(track);
        });
        return tracks;
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
