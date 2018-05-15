package com.sound.cloud.api.soundTracker.bootstrap;

import com.sound.cloud.api.soundTracker.integration.SoundCloudApiIntegration;
import com.sound.cloud.api.soundTracker.model.Track;
import com.sound.cloud.api.soundTracker.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private SoundCloudApiIntegration soundCloudApiIntegration;

    private TrackRepository trackRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Track> tracks =  (List<Track>)this.soundCloudApiIntegration.initTracks();
        this.trackRepository.saveAll(tracks);
    }

}
