package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.persistence.TalkRepository;
import de.gedoplan.workshop.qualifier.Current;

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
    this.talks = this.talkRepository.findAllWithSpeakers();
  }

  public List<Talk> getTalks()
  {
    return this.talks;
  }

  @Produces
  @Current
  Talk talk;

  public String editTalk(Talk talk)
  {
    this.talk = talk;
    return "talkEdit";
  }

  public String createTalk()
  {
    return editTalk(new Talk(null, null, null, null));
  }

}
