package de.gedoplan.workshop.cman.model;

import de.gedoplan.workshop.cman.entity.SpecialDay;
import de.gedoplan.workshop.cman.qualifier.All;
import de.gedoplan.workshop.cman.repository.SpecialDayRepository;

import java.io.Serializable;
import java.util.List;

import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@FlowScoped("specialDay")
public class SpecialDayModel implements Serializable
{
  private static final long serialVersionUID = 1L;

  @Inject
  @All
  private List<SpecialDay>  specialDays;

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

  @Inject
  SpecialDayRepository specialDayRepository;

  //
  //  @PostConstruct
  //  void postConstruct()
  //  {
  //    this.specialDays = this.specialDayRepository.findAll();
  //  }

  public String save()
  {
    for (SpecialDay specialDay : this.specialDays)
    {
      if (specialDay.getId() != null && !specialDay.getId().isEmpty())
      {
        this.specialDayRepository.merge(specialDay);
      }
    }

    return "exit";
  }

  public void addNewSpecialDay()
  {
    this.specialDays.add(new SpecialDay(null, null));
  }
}
