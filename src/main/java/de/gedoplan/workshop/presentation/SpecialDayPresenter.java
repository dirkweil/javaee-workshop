package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.SpecialDayRepository;
import de.gedoplan.workshop.qualifier.All;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class SpecialDayPresenter implements Serializable
{
  @Inject
  SpecialDayRepository     specialDayRepository;

  @Inject
  @All
  private List<SpecialDay> specialDays;

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

  //  @PostConstruct
  //  void init()
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

    return null;
  }

  public void addSpecialDay()
  {
    this.specialDays.add(new SpecialDay());
  }
}
