package com.sound.cloud.api.soundTracker.controllers;

import com.sound.cloud.api.soundTracker.pojos.TrackPojo;
import com.sound.cloud.api.soundTracker.model.Track;
import com.sound.cloud.api.soundTracker.services.TrackRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class TracksDataManagementController {

    @Autowired
    private TrackRequestService trackRequestService;

//    @GetMapping(value = "/api/getAllTracks")
//    public Collection<Track> getAllTracks() {
//      ArrayList<Track> tracks = new ArrayList<>();
//        tracks.add(new Track("my", "permalink"));
//        return tracks;
//    }

    @PostMapping(value = "/api/addTrack")
    public ResponseEntity<ArrayList<Track>> postNewTracks(@RequestBody TrackPojo trackPojo) {
       System.out.println("URL came ========  " + trackPojo.toString() + "  ==========");
       ArrayList<Track> tracks = new ArrayList<>();
       tracks.add(new Track(trackPojo.getTitle(), trackPojo.getPermalinkUrl()));
       return new ResponseEntity(tracks, HttpStatus.OK);
    }

}
