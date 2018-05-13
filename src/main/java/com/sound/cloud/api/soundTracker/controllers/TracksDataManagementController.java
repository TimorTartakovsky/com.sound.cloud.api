package com.sound.cloud.api.soundTracker.controllers;

import com.sound.cloud.api.soundTracker.model.Track;
import com.sound.cloud.api.soundTracker.repositories.TrackRepository;
import com.sound.cloud.api.soundTracker.services.TrackRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;

@Controller("TracksDataManagementController")
public class TracksDataManagementController {

    @Autowired
    private TrackRequestService trackRequestService;

    @PostMapping("addTrack")
    public ArrayList<Track> postNewTracks(@RequestParam("url") String  url) {
       System.out.println(url);
       return new ArrayList<Track>();
    }

}
