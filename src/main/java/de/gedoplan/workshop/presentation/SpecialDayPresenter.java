package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class SpecialDayPresenter
{
  // @Inject
  // SpecialDayRepository specialDayRepository;

  @Inject
  List<SpecialDay> specialDays;

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

  // @PostConstruct
  // private void init()
  // {
  // this.specialDays = this.specialDayRepository.findAll();
  // }
}
