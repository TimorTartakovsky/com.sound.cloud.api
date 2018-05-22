package com.sound.cloud.api.soundTracker.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ExpandedSearchQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bandName;
    @Column(name = "SOUND_CLOUD_RESULT", columnDefinition="TEXT")
    private String result;
    private Timestamp creationDate;

    public ExpandedSearchQuery() {
    }

    public ExpandedSearchQuery(String bandName, String result, Timestamp creationDate) {
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

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
}
