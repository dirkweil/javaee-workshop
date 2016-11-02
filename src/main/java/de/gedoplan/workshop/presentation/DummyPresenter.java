package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.entity.Dummy;
import de.gedoplan.workshop.persistence.DummyRepository;
import de.gedoplan.workshop.service.ApplicationVersionService;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import lombok.Getter;

@Model
public class DummyPresenter
{
  @Inject
  DummyRepository     dummyRepository;

  @Getter
  private List<Dummy> dummies;

  @PostConstruct
  void postConstruct()
  {
    this.dummies = this.dummyRepository.findAll();
  }

  @Inject
  ApplicationVersionService applicationVersionService;

  public String getApplicationCoordinates()
  {
    return this.applicationVersionService.getGav();
  }

  public String getApplicationName()
  {
    return this.applicationVersionService.getName();
  }

}
