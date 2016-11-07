package de.gedoplan.workshop.webservice;

import de.gedoplan.workshop.entity.Talk;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("talk")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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

  @PUT
  @Path("{hugo}")
  public void putById(@PathParam("hugo") Integer id, Talk talk) {
    Talk oldTalk = this.talkRepository.findById(id);
    if (oldTalk == null) {
      throw new NotFoundException();
    }

    this.talkRepository.merge(talk);
  }

  @POST
  public Response create(Talk talk, @Context UriInfo uriInfo) {
    this.talkRepository.persist(talk);

    URI location = uriInfo.getAbsolutePathBuilder().path(talk.getId().toString()).build();
    return Response.created(location).build();
  }
}
