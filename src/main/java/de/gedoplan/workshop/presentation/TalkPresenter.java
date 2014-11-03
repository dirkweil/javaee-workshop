package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.persistence.All;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.util.List;

import javax.enterprise.inject.Produces;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@FlowScoped("talk")
public class TalkPresenter
{
  @Inject
  @All
  List<Talk>     talks;

  @Produces
  @Current
  private Talk   currentTalk;

  @Inject
  TalkRepository talkRepository;

  public List<Talk> getTalks()
  {
    return this.talks;
  }

  public String select(Talk talk)
  {
    this.currentTalk = talk;
    return "talkEdit.xhtml";
  }
}
