package de.gedoplan.workshop.cman.gui;

import de.gedoplan.workshop.cman.persistence.Current;
import de.gedoplan.workshop.cman.persistence.Talk;
import de.gedoplan.workshop.cman.persistence.TalkRepository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@Model
public class TalkModel
{
  List<Talk>     talks;

  @Inject
  TalkRepository talkRepository;

  @Produces
  @Current
  private Talk   talk;

  @PostConstruct
  void postConstruct()
  {
    this.talks = this.talkRepository.findAll();
  }

  public List<Talk> getTalks()
  {
    return this.talks;
  }

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
