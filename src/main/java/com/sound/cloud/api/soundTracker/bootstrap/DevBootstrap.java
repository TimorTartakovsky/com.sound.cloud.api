package com.sound.cloud.api.soundTracker.bootstrap;

import com.sound.cloud.api.soundTracker.integration.SoundCloudApiIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private SoundCloudApiIntegration soundCloudApiIntegration;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.soundCloudApiIntegration.initTracks();
    }

}
