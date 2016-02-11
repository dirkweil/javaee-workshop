package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.domain.TalkType;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class TalkPresenter implements Serializable
{
  @Inject
  TalkRepository talkRepository;

  List<Talk>     talks;

  @PostConstruct
  void postConstruct()
  {
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
    return "talkEdit";
  }

  public String editTalk(Talk talk)
  {
    this.currentTalk = talk;
    return "talkEdit";
  }

  public Talk getCurrentTalk()
  {
    return this.currentTalk;
  }

  public TalkType[] getTalkTypes()
  {
    return TalkType.values();
  }

  public String save()
  {
    this.talkRepository.merge(this.currentTalk);

    return "home";
  }

}
