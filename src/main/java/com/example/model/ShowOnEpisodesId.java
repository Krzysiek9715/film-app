package com.example.model;


import javax.persistence.Embeddable;
import java.io.Serializable;

public class ShowOnEpisodesId implements Serializable {

    private Long showId;

    private Long episodeId;


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
}
