package de.gedoplan.workshop.cman.presentation;

import de.gedoplan.workshop.cman.entity.Talk;
import de.gedoplan.workshop.cman.persistence.TalkRepository;
import de.gedoplan.workshop.cman.qualifier.Current;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@Model
public class TalkPresenter implements Serializable
{
  private static final long serialVersionUID = 1L;

  private List<Talk>        talks;

  @Inject
  TalkRepository            talkRepository;

  @PostConstruct
  void postConstruct()
  {
    this.talks = this.talkRepository.findAll();
  }

  public List<Talk> getTalks()
  {
    return this.talks;
  }

  @Produces
  @Current
  private Talk talk;

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
