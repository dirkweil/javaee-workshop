package de.gedoplan.workshop.cman.rest;

import de.gedoplan.workshop.cman.entity.FertigungsAuftrag;
import de.gedoplan.workshop.cman.repository.FertigungsauftragRepository;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("fa")
public class FertigungsAuftragRestService
{
  @Inject
  FertigungsauftragRepository fertigungsauftragRepository;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<FertigungsAuftrag> getFertigungsAuftaege()
  {
    return this.fertigungsauftragRepository.findAll();
  }

}
