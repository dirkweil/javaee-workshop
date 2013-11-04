package de.gedoplan.workshop.cman.gui;

import de.gedoplan.workshop.cman.persistence.SpecialDay;
import de.gedoplan.workshop.cman.persistence.SpecialDayRepository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class SpecialDayModel
{
  List<SpecialDay>     specialDays;

  @Inject
  SpecialDayRepository specialDayRepository;

  @PostConstruct
  void postConstruct()
  {
    this.specialDays = this.specialDayRepository.findAll();
  }

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

}
