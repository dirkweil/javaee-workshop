package de.gedoplan.workshop.webservice;

import de.gedoplan.workshop.entity.Talk;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("talk")
@Produces(MediaType.APPLICATION_JSON)
public class TalkResource {
  @Inject
  TalkRepository talkRepository;

  @GET
  public List<Talk> getAll() {
    return this.talkRepository.findAll();
  }

  @GET
  @Path("{hugo}")
  public Talk getById(@PathParam("hugo") Integer id) {
    Talk talk = this.talkRepository.findById(id);
    if (talk != null) {
      return talk;
    }

    throw new NotFoundException();
    // throw new WebApplicationException(42);
  }
}
