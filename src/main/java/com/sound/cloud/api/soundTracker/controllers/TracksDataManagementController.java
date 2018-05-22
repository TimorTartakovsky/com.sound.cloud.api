package com.sound.cloud.api.soundTracker.controllers;

import com.sound.cloud.api.soundTracker.model.ExpandedTrack;
import com.sound.cloud.api.soundTracker.pojos.TrackPojo;
import com.sound.cloud.api.soundTracker.model.Track;
import com.sound.cloud.api.soundTracker.services.TrackRequestService;
import com.sound.cloud.api.soundTracker.services.TracksRuntimeStorage;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class TracksDataManagementController {

    @Autowired
    private TrackRequestService trackRequestService;

    @Autowired
    private TracksRuntimeStorage tracksRuntimeStorage;

    private static final Logger LOGGER = LoggerFactory.getLogger(TracksDataManagementController.class);
    private static final String SECRET_KEY = "Secret key 777";

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

    /*
     * tracksThreeMostAndLeastLiked handles a POST requests from end user with JSON body containing band_name and secret_key
     * return <ArrayList<ExpandedTrack>>
     * */
    @PostMapping(value = "/api/tracksThreeMostAndLeast")
    public ResponseEntity<ArrayList<ExpandedTrack>> tracksThreeMostAndLeastLiked(@RequestBody Map<String,String> body) {
        ArrayList<ExpandedTrack> tracks = this.handlePostRequestGetTracksByBandNameAndSecretKey(body.get("band_name"), body.get("secret_key"));
        LOGGER.info("=================== BandName: " + body.get("band_name") + "  SecretKey: " + body.get("secret_key") + "============================");
        return new ResponseEntity(tracks, HttpStatus.OK);
    }

    /*
    * tracksThreeMostAndLeastLiked handles a POST requests from end user with URL parameters band_name, secret_key
    * return <ArrayList<ExpandedTrack>>
    * */
    @PostMapping(value = "/api/tracksThreeMostAndLeast", params = {"band_name", "secret_key"})
    public ResponseEntity<ArrayList<ExpandedTrack>> tracksThreeMostAndLeastLiked(
            @RequestParam("band_name") String bandName,
            @RequestParam("secret_key") String secretKey
    ) {
        ArrayList<ExpandedTrack> tracks = this.handlePostRequestGetTracksByBandNameAndSecretKey(bandName, secretKey);
        LOGGER.info("=================== BandName: " + bandName + "  SecretKey: " + secretKey +"============================");
        return new ResponseEntity(tracks, HttpStatus.OK);
    }
    /*
    * handlePostRequestGetTracksByBandNameAndSecretKey helper function to handle request for 3 most and least liked tracks
    * @Param String bandName - band name received from end user to search for
    * @Param String secretKey - is need to authorize a person... )))
    * return ArrayList<ExpandedTrack> or ObjectNotFoundException, RestClientException
    * */
    private ArrayList<ExpandedTrack> handlePostRequestGetTracksByBandNameAndSecretKey (
            String bandName,
            String secretKey
    ) throws ObjectNotFoundException, RestClientException {
        if (secretKey == null || !secretKey.equals(SECRET_KEY)) {
            throw new ObjectNotFoundException(secretKey, "secret key cannot be found.");
        } else if (bandName == null || bandName.length() <= 1) {
            throw new ObjectNotFoundException(bandName, "band cannot be found.");
        }
        return trackRequestService.getThreeMostLikedAndThreeLeastLikedTracksByBandName(bandName);
    }

    // Under construction
    @PostMapping(value = "/api/addTrack")
    public ResponseEntity<ArrayList<Track>> postNewTracks(@RequestBody TrackPojo trackPojo) {
       Track newTrack = new Track();
       newTrack.setTitle(trackPojo.getTitle());
       newTrack.setPermalinkUrl(trackPojo.getPermalinkUrl());
       this.trackRequestService.addNewTrack(newTrack);
       LOGGER.info("POST /api/addTrack success");
       return new ResponseEntity(newTrack, HttpStatus.OK);
    }

}
