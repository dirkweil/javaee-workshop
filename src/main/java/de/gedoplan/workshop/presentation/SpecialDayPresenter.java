package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class SpecialDayPresenter
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
  // private void init()
  // {
  // this.specialDays = this.specialDayRepository.findAll();
  // }

  @Transactional
  public void saveAll()
  {
    for (SpecialDay specialDay : this.specialDays)
    {
      this.specialDayRepository.merge(specialDay);
    }
  }
}
