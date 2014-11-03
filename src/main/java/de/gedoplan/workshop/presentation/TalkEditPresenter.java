package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.domain.TalkType;
import de.gedoplan.workshop.persistence.TalkRepository;

import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@FlowScoped("talk")
public class TalkEditPresenter
{
  @Inject
  TalkRepository talkRepository;

  @Inject
  @Current
  private Talk   currentTalk;

  public Talk getCurrentTalk()
  {
    return this.currentTalk;
  }

  public String save()
  {
    this.talkRepository.merge(this.currentTalk);
    return "exit";
  }

  public TalkType[] getTalkTypes()
  {
    return TalkType.values();
  }

}
