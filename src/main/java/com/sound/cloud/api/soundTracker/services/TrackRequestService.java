package com.sound.cloud.api.soundTracker.services;
import com.google.gson.internal.LinkedTreeMap;
import com.sound.cloud.api.soundTracker.integration.SoundCloudConnector;
import com.sound.cloud.api.soundTracker.model.ExpandedTrack;
import com.sound.cloud.api.soundTracker.model.Track;
import com.sound.cloud.api.soundTracker.repositories.ExpandedTrackRepository;
import com.sound.cloud.api.soundTracker.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.math.BigDecimal;
import java.util.*;

@Service("TrackRequestService")
public class TrackRequestService {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private TracksRuntimeStorage tacksRuntimeStorage;

    @Autowired
    private SoundCloudConnector soundCloudConnector;

    @Autowired
    private ExpandedTrackRepository expandedTrackRepository;

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


    public ArrayList<ExpandedTrack > getThreeMostLikedAndThreeLeastLikedTracksByBandName(String bandName) throws RestClientException {
        ArrayList<LinkedTreeMap<String, Object>> expandedTracksArray = this.soundCloudConnector.getTracksByBandName(bandName);
        ArrayList<ExpandedTrack> myExpandedTracks = new ArrayList<>();

        Comparator<ExpandedTrack> likesCountComparator = (ExpandedTrack one, ExpandedTrack two) -> Double.compare(one.getLikesCount(), two.getLikesCount());
        expandedTracksArray.forEach(track -> {
            Double likes = (Double)track.get("likes_count");
            myExpandedTracks.add(
                    new ExpandedTrack(
                            track.get("title").toString(),
                            track.get("description").toString(),
                            likes,
                            track.get("tag_list").toString()));
        });
        Collections.sort(myExpandedTracks, likesCountComparator);

        ArrayList<ExpandedTrack> likedTracks = new ArrayList<>();
        likedTracks.add(myExpandedTracks.get(0));
        likedTracks.add(myExpandedTracks.get(1));
        likedTracks.add(myExpandedTracks.get(2));

        likedTracks.add(myExpandedTracks.get(myExpandedTracks.size() - 3));
        likedTracks.add(myExpandedTracks.get(myExpandedTracks.size() - 2));
        likedTracks.add(myExpandedTracks.get(myExpandedTracks.size() - 1));

        expandedTrackRepository.saveAll((Iterable<ExpandedTrack>)myExpandedTracks);
        return likedTracks;
    }

    public ArrayList<ExpandedTrack> getTracksByBandNameAndUserId(String bandName, String userId) {
        return null;
    }

}
