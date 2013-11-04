package de.gedoplan.workshop.cman.gui;

import de.gedoplan.workshop.cman.persistence.Current;
import de.gedoplan.workshop.cman.persistence.Talk;
import de.gedoplan.workshop.cman.persistence.TalkRepository;
import de.gedoplan.workshop.cman.persistence.TalkType;

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

}
