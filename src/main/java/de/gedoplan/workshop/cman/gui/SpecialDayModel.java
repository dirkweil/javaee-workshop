package de.gedoplan.workshop.cman.gui;

import de.gedoplan.workshop.cman.persistence.All;
import de.gedoplan.workshop.cman.persistence.SpecialDay;
import de.gedoplan.workshop.cman.persistence.SpecialDayRepository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
@FlowScoped("specialDay")
public class SpecialDayModel implements Serializable
{
  private static final long serialVersionUID = 1L;

  @Inject
  @All
  List<SpecialDay>          specialDays;

  @Inject
  SpecialDayRepository      specialDayRepository;

  //
  //  @PostConstruct
  //  void postConstruct()
  //  {
  //    this.specialDays = this.specialDayRepository.findAll();
  //  }

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

  public void addSpecialDay()
  {
    this.specialDays.add(new SpecialDay());
  }

  // TODO: Ist das noch Präsentationslogik? In Service auslagern
  @Transactional
  public String save()
  {
    for (SpecialDay specialDay : this.specialDays)
    {
      if (specialDay.getId() != null && !specialDay.getId().isEmpty())
      {
        this.specialDayRepository.merge(specialDay);
      }
    }

    return "home";
  }
}
