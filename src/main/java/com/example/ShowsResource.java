package com.example;

import com.example.model.Episode;
import com.example.model.Season;
import com.example.model.Season1;
import com.example.model.Show;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/shows")
@Produces(MediaType.APPLICATION_JSON)
public class ShowsResource {

    @Inject
    @RestClient
    ShowsService showsService;


    @GET
    @Path("/all")
    public List<Show> getAllShows() {
        return showsService.getAllShows();
    }

    @GET
    @Path("/size")
    @Produces(MediaType.TEXT_PLAIN)
    public int getAllShows2() {
        return showsService.getAllShows().size();
    }

    @GET
    @Path("/seasons")
    public List<Season> getSeasonsById(){
        return showsService.getDataByShowId(1L);
    }


    @GET
    @Path("/seasons/tfu/{pageStart}")
    public List<Season1> getAllSeasons(@PathParam("pageStart") Long pageStart){
        List<Season1> season1List = new ArrayList<>();
        Long pageEnd = pageStart+10;
        for (Long id=pageStart;id<pageEnd;id++){
            season1List.addAll(getSeasonsFromShows(id));
        }
        return season1List;
    }


    @GET
    @Path("/seasons/{id}")
    public List<Season1> getSeasonsFromShows(@PathParam("id") Long id){
        List<Season> seasonsByShowId = showsService.getDataByShowId(id);
        return seasonsByShowId.stream()
                    .map(soa-> new Season1(id,soa.getId(), soa.getSeason(),soa.getNumber()))
                    .collect(Collectors.toList());
    }


    @GET
    @Path("/episodes/{id}")
    public List<Episode> getEpisodesFromShows(@PathParam("id") Long id){
        List<Episode> episodeByShowId = showsService.getEpisodesByShowId(id);
        return episodeByShowId.stream()
                .map(soa-> new Episode(soa.getId(),soa.getName()))
                .collect(Collectors.toList());
    }

}