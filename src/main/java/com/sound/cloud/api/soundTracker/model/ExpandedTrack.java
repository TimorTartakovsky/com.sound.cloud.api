package com.sound.cloud.api.soundTracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class ExpandedTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Double likesCount;
    private String tagList;

    public ExpandedTrack() {
    }

    public ExpandedTrack(String title, String description, Double likesCount, String tagList) {
        this.title = title;
        this.description = description;
        this.likesCount = likesCount;
        this.tagList = tagList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpandedTrack that = (ExpandedTrack) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(likesCount, that.likesCount) &&
                Objects.equals(tagList, that.tagList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, likesCount, tagList);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLikesCount() { return likesCount; }

    public void setLikesCount(Double likesCount) {
        this.likesCount = likesCount;
    }

    public String getTagList() {
        return tagList;
    }

    public void setTagList(String tagList) {
        this.tagList = tagList;
    }

    @Override
    public String toString() {
        return "ExpandedTrack{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", likesCount=" + likesCount +
                ", tagList='" + tagList + '\'' +
                '}';
    }
}
