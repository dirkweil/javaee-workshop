package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class SpecialDayPresenter
{
  @Inject
  SpecialDayRepository specialDayRepository;

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDayRepository.findAll();
  }

}
