package de.gedoplan.workshop.webservice;

import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("talk")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class TalkResource
{
  @Inject
  TalkRepository talkRepository;

  @GET
  public List<Talk> getTalks()
  {
    return this.talkRepository.findAll();
  }

  @GET
  @Path("{xyz}")
  public Talk getTalk(@PathParam("xyz") Integer id)
  {
    Talk talk = this.talkRepository.findById(id);
    if (talk == null)
    {
      throw new NotFoundException();
    }
    return talk;
  }

  @POST
  @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  public Response createTalk(Talk talk, @Context UriInfo uriInfo)
  {
    this.talkRepository.persist(talk);

    URI uri = uriInfo.getAbsolutePathBuilder()
        .path(TalkResource.class, "getTalk")
        .resolveTemplate("xyz", talk.getId())
        .build();

    return Response.created(uri).build();
  }
}
