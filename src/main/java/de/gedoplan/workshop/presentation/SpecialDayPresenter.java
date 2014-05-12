package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SpecialDayPresenter
{
  @Inject
  SpecialDayRepository specialDayRepository;

  public List<SpecialDay> getSpecialDays()
  {
    // TODO: Nicht gut!
    return this.specialDayRepository.findAll();
  }

}
