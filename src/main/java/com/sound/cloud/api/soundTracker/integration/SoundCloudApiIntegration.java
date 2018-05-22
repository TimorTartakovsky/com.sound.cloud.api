package com.sound.cloud.api.soundTracker.integration;

import com.google.gson.internal.LinkedTreeMap;
import com.sound.cloud.api.soundTracker.components.ThreadBasedComponent;
import com.sound.cloud.api.soundTracker.interfaces.ISoundCloudApiIntegration;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;

@Service
public class SoundCloudApiIntegration implements ISoundCloudApiIntegration {

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private ApplicationContext applicationContext;

    public void initPredefinedTracks() throws RestClientException {
        for (String band : FAVORIETS) {
            ThreadBasedComponent thread = this.applicationContext.getBean(ThreadBasedComponent.class).setTrackName(band);
            this.taskExecutor.execute(thread);
        }
    }

    @Override
    public ArrayList<LinkedTreeMap<String, Object>> initTracks() {
        return null;
    }
}
