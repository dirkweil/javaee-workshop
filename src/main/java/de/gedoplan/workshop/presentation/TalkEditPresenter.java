package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.domain.TalkType;
import de.gedoplan.workshop.persistence.TalkRepository;
import de.gedoplan.workshop.qualifier.Current;

import java.io.Serializable;

import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@FlowScoped("talkEdit")
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

}
