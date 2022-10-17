package com.example.model;


import javax.persistence.EmbeddedId;

public class Season1 {


    private ShowOnEpisodesId id;

    private Long showId;
    private Long episodeId;
    private String season;

    private Long number;


    public Season1() {
    }


    public Season1(Long showId, Long episodeId, String season, Long number) {
        this.showId = showId;
        this.episodeId = episodeId;
        this.season = season;
        this.number = number;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Long getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Long episodeId) {
        this.episodeId = episodeId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
