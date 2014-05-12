package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class SpecialDayPresenter
{
  @Inject
  SpecialDayRepository     specialDayRepository;

  private List<SpecialDay> specialDays;

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

  @PostConstruct
  void init()
  {
    this.specialDays = this.specialDayRepository.findAll();
  }

  public String save()
  {
    for (SpecialDay specialDay : this.specialDays)
    {
      this.specialDayRepository.merge(specialDay);
    }

    return null;
  }

}
