package com.sound.cloud.api.soundTracker.integration;

import com.sound.cloud.api.soundTracker.components.ThreadBasedComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
public class SoundCloudApiIntegration {

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private ApplicationContext applicationContext;

    public void initTracks() throws RestClientException {
        ThreadBasedComponent thread1 = this.applicationContext.getBean(ThreadBasedComponent.class).setTrackName("Bee Gees");
        ThreadBasedComponent thread2 = this.applicationContext.getBean(ThreadBasedComponent.class).setTrackName("2pac");
        ThreadBasedComponent thread3 = this.applicationContext.getBean(ThreadBasedComponent.class).setTrackName("Michael Jackson");

        this.taskExecutor.execute(thread1);
        this.taskExecutor.execute(thread2);
        this.taskExecutor.execute(thread3);
    }
}
