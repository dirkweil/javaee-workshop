package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
@ViewScoped
public class SpecialDayPresenter implements Serializable
{
  @Inject
  SpecialDayRepository specialDayRepository;

  @Inject
  List<SpecialDay>     specialDays;

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

  // @PostConstruct
  // private void postConstruct()
  // {
  // this.specialDays = this.specialDayRepository.findAll();
  // }

  @Transactional
  public String save()
  {
    for (SpecialDay specialDay : this.specialDays)
    {
      this.specialDayRepository.merge(specialDay);
    }

    return "home";
  }

  public void addSpecialDay()
  {
    this.specialDays.add(new SpecialDay());
  }

  @PostConstruct
  void start()
  {
    System.out.println("start");
  }

  @PreDestroy
  void leave()
  {
    System.out.println("leave");
  }
}
