package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "specialDayPresenter")
@RequestScoped
public class SpecialDayPresenter
{
  @Inject
  SpecialDayRepository specialDayRepository;

  List<SpecialDay>     specialDays;

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

  @PostConstruct
  void init()
  {
    System.out.println("##############");
    this.specialDays = this.specialDayRepository.findAll();
  }

  // public SpecialDayPresenter()
  // {
  // System.out.println("++++++++++++++++");
  // }
}
