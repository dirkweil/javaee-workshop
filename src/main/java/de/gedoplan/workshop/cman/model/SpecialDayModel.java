package de.gedoplan.workshop.cman.model;

import de.gedoplan.workshop.cman.entity.SpecialDay;
import de.gedoplan.workshop.cman.qualifier.All;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class SpecialDayModel
{
  @Inject
  @All
  private List<SpecialDay> specialDays;

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

  //  @Inject
  //  SpecialDayRepository specialDayRepository;
  //
  //  @PostConstruct
  //  void postConstruct()
  //  {
  //    this.specialDays = this.specialDayRepository.findAll();
  //  }
}
