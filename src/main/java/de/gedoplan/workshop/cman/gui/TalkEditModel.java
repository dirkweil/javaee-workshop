package de.gedoplan.workshop.cman.gui;

import de.gedoplan.workshop.cman.persistence.All;
import de.gedoplan.workshop.cman.persistence.Current;
import de.gedoplan.workshop.cman.persistence.SpecialDay;
import de.gedoplan.workshop.cman.persistence.Talk;
import de.gedoplan.workshop.cman.persistence.TalkRepository;
import de.gedoplan.workshop.cman.persistence.TalkType;

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
  Talk talk;

  public Talk getTalk()
  {
    return this.talk;
  }

  @Inject
  TalkRepository talkRepository;

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
  private List<SpecialDay> specialDays;

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

}
