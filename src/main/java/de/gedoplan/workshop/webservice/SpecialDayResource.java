package de.gedoplan.workshop.webservice;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.All;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("specialDay")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class SpecialDayResource
{
  @Inject
  @All
  List<SpecialDay>     specialDays;

  @Inject
  SpecialDayRepository specialDayRepository;

  @GET
  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

  @GET
  @Path("{id}")
  public SpecialDay getSpecialDay(@PathParam("id") String id)
  {
    return this.specialDayRepository.findById(id);
  }

}
