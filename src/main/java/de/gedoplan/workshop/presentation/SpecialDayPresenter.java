package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
//@SessionScoped
@FlowScoped("specialDay")
public class SpecialDayPresenter implements Serializable
{
  @Inject
  SpecialDayRepository specialDayRepository;

  List<SpecialDay>     specialDays;

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

  @PostConstruct
  void fillSpecialDays()
  {
    //    System.out.println("Enter flow specialDay");
    this.specialDays = this.specialDayRepository.findAll();
  }

  @PreDestroy
  void preDestroy()
  {
    //    System.out.println("Leave flow specialDay");
  }

  public void addSpecialDay()
  {
    this.specialDays.add(new SpecialDay());
  }

  public String save()
  {
    for (SpecialDay specialDay : this.specialDays)
    {
      if (specialDay.getId() != null && !specialDay.getId().isEmpty())
      {
        this.specialDayRepository.merge(specialDay);
      }
    }

    return "exit";
  }
}
