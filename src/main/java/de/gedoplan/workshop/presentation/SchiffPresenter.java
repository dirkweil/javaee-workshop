package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.Schiff;
import de.gedoplan.workshop.persistence.SchiffRepository;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
@SessionScoped
public class SchiffPresenter implements Serializable
{
  List<Schiff>     schiffe;

  @Inject
  SchiffRepository schiffRepository;

  private Schiff   currentSchiff;

  public List<Schiff> getSchiffe()
  {
    return this.schiffe;
  }

  @PostConstruct
  private void init()
  {
    this.schiffe = this.schiffRepository.findAll();
  }

  public String edit(Schiff schiff)
  {
    this.currentSchiff = schiff;
    return "edit";
  }

  public Schiff getCurrentSchiff()
  {
    return this.currentSchiff;
  }

  public String save()
  {
    this.schiffRepository.save(this.currentSchiff);
    return "ok";
  }

}
