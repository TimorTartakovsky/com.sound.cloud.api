package com.sound.cloud.api.soundTracker.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String bandName;
    private Double likesCount;
    private String permalinkUrl;
    @ManyToMany
    @JoinTable(name="user_track", joinColumns = @JoinColumn(name = "track_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    public Track() {}

    public Track(String title, String bandName, Double likesCount, String permalinkUrl) {
        this.title = title;
        this.bandName = bandName;
        this.likesCount = likesCount;
        this.permalinkUrl = permalinkUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(id, track.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public String getBandName() { return bandName; }

    public void setBandName(String bandName) { this.bandName = bandName; }

    public Double getLikesCount() { return likesCount; }

    public void setLikesCount(Double likesCount) { this.likesCount = likesCount; }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPermalinkUrl() {
        return permalinkUrl;
    }

    public void setPermalinkUrl(String permalinkUrl) {
        this.permalinkUrl = permalinkUrl;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", permalinkUrl='" + permalinkUrl + '\'' +
                ", users=" + users +
                '}';
    }
}
