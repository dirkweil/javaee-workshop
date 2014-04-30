package de.gedoplan.workshop.cman.model;

import de.gedoplan.workshop.cman.entity.FertigungsAuftrag;
import de.gedoplan.workshop.cman.repository.FertigungsauftragRepository;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class FertigungsAuftragModel
{
  @Inject
  FertigungsauftragRepository fertigungsauftragRepository;

  public List<FertigungsAuftrag> getFertigungsAuftaege()
  {
    // TODO: Direkter Durchgriff ist ungünstig; besser nur einmal und cachen
    return this.fertigungsauftragRepository.findAll();
  }
}
