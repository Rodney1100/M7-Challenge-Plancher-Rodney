package com.company.musicstorecatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "track")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id")
    private Long id;

    @NotNull
    @Column(name = "album_id")
    private String albumId;

    @NotNull
    @Length(max = 255)
    private String title;

    @NotNull
    @Column(name = "run_time")
    private String runTime;

    public Track(Long id, String albumId, String title, String runTime) {
        this.id = id;
        this.title = title;
        this.albumId = albumId;
        this.runTime = runTime;
    }

    public Track(String albumId, String title, String runTime) {
        this.title = title;
        this.albumId = albumId;
        this.runTime = runTime;
    }

    public Track() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", albumId='" + albumId + '\'' +
                ", title='" + title + '\'' +
                ", runTime='" + runTime + '\'' +
                '}';
    }
}
