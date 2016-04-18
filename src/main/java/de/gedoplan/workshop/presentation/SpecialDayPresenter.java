package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
@SessionScoped
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
    this.specialDays = this.specialDayRepository.findAll();
  }

  @Transactional
  public void save()
  {
    for (SpecialDay specialDay : this.specialDays)
    {
      this.specialDayRepository.merge(specialDay);
    }
  }

  public void add()
  {
    this.specialDays.add(new SpecialDay(null, null));
  }

}
