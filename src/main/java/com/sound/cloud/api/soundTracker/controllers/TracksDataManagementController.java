package com.sound.cloud.api.soundTracker.controllers;

import com.sound.cloud.api.soundTracker.pojos.TrackPojo;
import com.sound.cloud.api.soundTracker.model.Track;
import com.sound.cloud.api.soundTracker.services.TrackRequestService;
import com.sound.cloud.api.soundTracker.services.TracksRuntimeStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class TracksDataManagementController {

    @Autowired
    private TrackRequestService trackRequestService;

    @Autowired
    private TracksRuntimeStorage tracksRuntimeStorage;

    private static final Logger LOGGER = LoggerFactory.getLogger(TracksDataManagementController.class);


    @DeleteMapping(value = "/api/deleteTrack/id/{id}")
    public ResponseEntity<Long> deleteTrackByID(@PathVariable Long  id) {
        this.trackRequestService.deleteTrackById(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/deleteTrack/permalink/{permalink}")
    public ResponseEntity<Long> deleteTrackByPermalink(@PathVariable String permalink) {
        this.trackRequestService.deleteTrackByPermalink(permalink);
        return new ResponseEntity(permalink, HttpStatus.OK);
    }

    @GetMapping(value = "/api/getAllTracks")
    public ResponseEntity<ArrayList<Track>> getAllTracks() {
        ArrayList<Track> tracks = this.tracksRuntimeStorage.getAllTracks();
        if (tracks.size() == 0) {
            tracks = this.trackRequestService.getAllTracks();
        }

        tracks.forEach((track -> LOGGER.info(track.toString())));

        LOGGER.info("GET /api/getAllTracks success");
        return new ResponseEntity(tracks, HttpStatus.OK);
    }


    // Under construction
    @PostMapping(value = "/api/addTrack")
    public ResponseEntity<ArrayList<Track>> postNewTracks(@RequestBody TrackPojo trackPojo) {
       System.out.println("URL came ========  " + trackPojo.toString() + "  ==========");
       ArrayList<Track> tracks = new ArrayList<>();
       tracks.add(new Track(trackPojo.getTitle(), trackPojo.getPermalinkUrl()));
       LOGGER.info("POST /api/addTrack success");
       return new ResponseEntity(tracks, HttpStatus.OK);
    }

}
