package de.gedoplan.workshop.webservice;

import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
  @Path("{id}")
  public Talk getTalk(@PathParam("id") Integer id)
  {
    return this.talkRepository.findById(id);
  }

}
