package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.domain.TalkType;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;

@Model
@FlowScoped("editTalk")
public class TalkEditPresenter implements Serializable
{
  @Inject
  TalkRepository talkRepository;

  @Inject
  @Current
  Talk           talk;

  public Talk getTalk()
  {
    return this.talk;
  }

  public TalkType[] getTalkTypes()
  {
    return TalkType.values();
  }

  public String save()
  {
    this.talkRepository.merge(this.talk);

    return "ok";
  }

  @Inject
  private List<SpecialDay> specialDays;

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

}
