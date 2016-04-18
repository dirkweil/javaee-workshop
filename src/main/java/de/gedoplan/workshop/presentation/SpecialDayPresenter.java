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
import javax.transaction.Transactional;

@Named
@FlowScoped("specialDay")
public class SpecialDayPresenter implements Serializable
{
  @Inject
  SpecialDayRepository     specialDayRepository;

  private List<SpecialDay> specialDays;

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

  @PostConstruct
  void init()
  {
    System.out.println("init");
    this.specialDays = this.specialDayRepository.findAll();
  }

  @PreDestroy
  void cleanup()
  {
    System.out.println("cleanup");
  }

  @Transactional
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

}
