package de.gedoplan.workshop.webservice;

import de.gedoplan.workshop.domain.Schiff;
import de.gedoplan.workshop.persistence.SchiffRepository;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("schiff")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class SchiffRestResource
{
  @Inject
  SchiffRepository schiffRepository;

  @GET
  public List<Schiff> getAll()
  {
    return this.schiffRepository.findAll();
  }

  @GET
  @Path("{id}")
  public Schiff getbyId(@PathParam("id") Integer id)
  {
    return this.schiffRepository.findById(id);
  }

}
