package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "specialDayPresenter")
@RequestScoped
public class SpecialDayPresenter
{
  @Inject
  SpecialDayRepository specialDayRepository;

  public List<SpecialDay> getSpecialDays()
  {
    System.out.println("##############");
    return this.specialDayRepository.findAll();
  }

  // public SpecialDayPresenter()
  // {
  // System.out.println("++++++++++++++++");
  // }
}
