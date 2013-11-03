package de.gedoplan.workshop.cman.model;

import de.gedoplan.workshop.cman.entity.SpecialDay;
import de.gedoplan.workshop.cman.entity.Talk;
import de.gedoplan.workshop.cman.entity.TalkType;
import de.gedoplan.workshop.cman.qualifier.All;
import de.gedoplan.workshop.cman.qualifier.Current;
import de.gedoplan.workshop.cman.repository.TalkRepository;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;

@Model
@FlowScoped("talkEdit")
public class TalkEditModel
{
  @Inject
  @Current
  Talk           talk;

  @Inject
  TalkRepository talkRepository;

  public Talk getTalk()
  {
    return this.talk;
  }

  public String save()
  {
    this.talkRepository.merge(this.talk);
    return "exit";
  }

  public TalkType[] getTalkTypes()
  {
    return TalkType.values();
  }

  @Inject
  @All
  List<SpecialDay> specialDays;

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

}
