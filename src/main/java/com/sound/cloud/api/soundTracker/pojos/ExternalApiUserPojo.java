package com.sound.cloud.api.soundTracker.pojos;

import java.sql.Timestamp;

public class ExternalApiUserPojo {

    private String avatar_url;
    private Long id;
    private String kind;
    private String permalink_url;
    private String uri;
    private String username;
    private String permalink;
    private Timestamp last_modified;

    public ExternalApiUserPojo() {
    }

    public ExternalApiUserPojo(String avatar_url, Long id, String kind, String permalink_url, String uri, String username, String permalink, Timestamp last_modified) {
        this.avatar_url = avatar_url;
        this.id = id;
        this.kind = kind;
        this.permalink_url = permalink_url;
        this.uri = uri;
        this.username = username;
        this.permalink = permalink;
        this.last_modified = last_modified;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getPermalink_url() {
        return permalink_url;
    }

    public void setPermalink_url(String permalink_url) {
        this.permalink_url = permalink_url;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public Timestamp getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Timestamp last_modified) {
        this.last_modified = last_modified;
    }
}
