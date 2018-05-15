package com.sound.cloud.api.soundTracker.controllers;

import com.sound.cloud.api.soundTracker.model.Track;
import com.sound.cloud.api.soundTracker.services.TrackRequestService;
import com.sound.cloud.api.soundTracker.services.TracksRuntimeStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class ViewRepresentationController {

    @Autowired
    private TrackRequestService trackRequestService;

    @Autowired
    private TracksRuntimeStorage tracksRuntimeStorage;

    private static final Logger LOGGER = LoggerFactory.getLogger(TracksDataManagementController.class);

    @RequestMapping({"", "/", "/index"})
    public String mainPageRepresentation(Model model) {
        ArrayList<Track> tracks = this.tracksRuntimeStorage.getAllTracks();
        if (tracks.size() == 0) {
            tracks = this.trackRequestService.getAllTracks();
        }
        model.addAttribute("tracks", tracks);
        tracks.forEach((track -> LOGGER.info(track.toString())));
        return "tracks";
    }

    @GetMapping("/tracks")
    public String tracksPageRepresentation(Model model) {
        ArrayList<Track> tracks = this.tracksRuntimeStorage.getAllTracks();
        if (tracks.size() == 0) {
            tracks = this.trackRequestService.getAllTracks();
        }
        model.addAttribute("tracks", tracks);
        tracks.forEach((track -> LOGGER.info(track.toString())));
        LOGGER.info("GET /tracks success");
        return "tracks";
    }

}
