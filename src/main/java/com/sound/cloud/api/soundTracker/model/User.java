package com.sound.cloud.api.soundTracker.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String avatarUrl;
    private String kind; // Enum could be used instead, currently using String because don't know full list of possible statuses
    private String permalinkUrl;
    private String uri;
    private String userName;
    private String permalink;
    private String lastModified;
    @ManyToMany(mappedBy = "users")
    private Set<Track> tracks = new HashSet<>();

    public User() {}

    public User(String avatarUrl, String kind, String permalinkUrl, String uri, String userName, String permalink, String lastModified) {
        this.avatarUrl = avatarUrl;
        this.kind = kind;
        this.permalinkUrl = permalinkUrl;
        this.uri = uri;
        this.userName = userName;
        this.permalink = permalink;
        this.lastModified = lastModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getPermalinkUrl() {
        return permalinkUrl;
    }

    public void setPermalinkUrl(String permalinkUrl) {
        this.permalinkUrl = permalinkUrl;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", kind='" + kind + '\'' +
                ", permalinkUrl='" + permalinkUrl + '\'' +
                ", uri='" + uri + '\'' +
                ", userName='" + userName + '\'' +
                ", permalink='" + permalink + '\'' +
                ", lastModified=" + lastModified +
                ", tracks=" + tracks +
                '}';
    }
}


