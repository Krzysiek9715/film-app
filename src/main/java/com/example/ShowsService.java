package com.example;


import com.example.model.Episode;
import com.example.model.Season;
import com.example.model.Show;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("shows")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "movies-api")
public interface ShowsService {

    @GET
    List<Show> getAllShows();

    @GET
    @Path("{id}/episodes")
    List<Season> getDataByShowId(@PathParam("id") Long id);

    @GET
    @Path("{id}/episodes")
    List<Episode> getEpisodesByShowId(@PathParam("id") Long id);

}
