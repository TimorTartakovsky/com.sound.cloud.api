package com.sound.cloud.api.soundTracker.services;
import com.sound.cloud.api.soundTracker.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TrackRequestService")
public class TrackRequestService {

    @Autowired
    private TrackRepository trackRepository;



}
