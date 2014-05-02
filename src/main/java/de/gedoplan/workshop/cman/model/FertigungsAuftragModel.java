package de.gedoplan.workshop.cman.model;

import de.gedoplan.workshop.cman.entity.FertigungsAuftrag;
import de.gedoplan.workshop.cman.repository.FertigungsAuftragRepository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class FertigungsAuftragModel
{
  @Inject
  FertigungsAuftragRepository     fertigungsAuftragRepository;

  private List<FertigungsAuftrag> fertigungsAuftraege;

  @PostConstruct
  private void init()
  {
    this.fertigungsAuftraege = this.fertigungsAuftragRepository.findAll();
  }

  public List<FertigungsAuftrag> getFertigungsAuftraege()
  {
    return this.fertigungsAuftraege;
  }
}
