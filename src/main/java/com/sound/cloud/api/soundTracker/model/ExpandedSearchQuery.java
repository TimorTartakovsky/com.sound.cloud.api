package com.sound.cloud.api.soundTracker.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ExpandedSearchQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bandName;
    @Column(name = "SOUND_CLOUD_RESULT", columnDefinition="TEXT")
    private String result;
    private Date creationDate;

    public ExpandedSearchQuery() {
    }

    public ExpandedSearchQuery(String bandName, String result, Date creationDate) {
        this.bandName = bandName;
        this.result = result;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
