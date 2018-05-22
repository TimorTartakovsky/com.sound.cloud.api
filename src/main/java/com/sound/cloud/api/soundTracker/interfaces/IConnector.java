package com.sound.cloud.api.soundTracker.interfaces;

import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;

public interface IConnector extends ISoundCloudApiIntegration {

    ArrayList<LinkedTreeMap<String, Object>> getTracksByBandName(String bandName);
    ArrayList<LinkedTreeMap<String, Object>> getTracksByBandNameAndUserId(String bandName, Integer userId);

}
