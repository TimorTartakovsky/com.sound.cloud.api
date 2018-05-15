package com.sound.cloud.api.soundTracker.interfaces;

import com.sound.cloud.api.soundTracker.model.Track;

import java.util.Collection;
import java.util.List;

public interface ISoundCloudApiIntegration {

    public static final String BASE_SOUND_CLOUD_URL = "http://api.soundcloud.com/";
    public static final String TRACKS = "tracks/?q=";
    public static final String PLAY_LIST = "playlists/?q=";
    public static final String FOLLOWINGS = "followings/?q=";
    public static final String FOLLOWERS = "followers/?q=";
    public static final String COMMENTS = "comments/?q=";
    public static final String FAVORITES = "favorites/?q=";
    public static final String WEB_PROFILES = "web-profiles/?q=";
    public static final String[] FAVORIETS = {"2pac", "Easy-E", "Ice Cube"};
    public static final String CLIENT_ID = "&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";

    List<?> initTracks();
}
