package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.All;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "specialDayPresenter")
@SessionScoped
public class SpecialDayPresenter implements Serializable
{
  @Inject
  SpecialDayRepository specialDayRepository;

  @Inject
  @All
  List<SpecialDay>     specialDays;

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

  public String save()
  {
    for (SpecialDay specialDay : this.specialDays)
    {
      this.specialDayRepository.merge(specialDay);
    }

    return "home";
  }

  public void add()
  {
    this.specialDays.add(new SpecialDay(null, null));
  }

  // @PostConstruct
  // void init()
  // {
  // System.out.println("##############");
  // this.specialDays = this.specialDayRepository.findAll();
  // }

  // public SpecialDayPresenter()
  // {
  // System.out.println("++++++++++++++++");
  // }
}
