package de.gedoplan.workshop.cman.rest;

import de.gedoplan.workshop.cman.entity.FertigungsAuftrag;
import de.gedoplan.workshop.cman.repository.FertigungsAuftragRepository;

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
  FertigungsAuftragRepository fertigungsAuftragRepository;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<FertigungsAuftrag> getFertigungsAuftraege()
  {
    return this.fertigungsAuftragRepository.findAll();
  }

}
