package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.All;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "specialDayPresenter")
@FlowScoped("specialDay")
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

    return "exit";
  }

  public void add()
  {
    this.specialDays.add(new SpecialDay(null, null));
  }

  @PostConstruct
  void init()
  {
    System.out.println("Flow start");
  }

  @PreDestroy
  void cleanup()
  {
    System.out.println("Flow end");
  }

  // public SpecialDayPresenter()
  // {
  // System.out.println("++++++++++++++++");
  // }
}
