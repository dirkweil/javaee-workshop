package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@Model
public class TalkPresenter
{
  @Inject
  TalkRepository talkRepository;

  List<Talk>     talks;

  @PostConstruct
  void postConstruct()
  {
    // this.talks = this.talkRepository.findAllWithSpeakers();
    this.talks = this.talkRepository.findAll();
  }

  public List<Talk> getTalks()
  {
    return this.talks;
  }

  private Talk currentTalk;

  public String createTalk()
  {
    this.currentTalk = new Talk(null, null, null, null);
    return "editTalk";
  }

  @Produces
  @Current
  public Talk getCurrentTalk()
  {
    return this.currentTalk;
  }

}
