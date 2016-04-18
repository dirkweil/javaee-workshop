package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.domain.TalkType;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;

@Model
@FlowScoped("talk")
public class TalkPresenter implements Serializable
{
  @Inject
  TalkRepository talkRepository;

  List<Talk>     talks;

  @PostConstruct
  void postConstruct()
  {
    this.talks = this.talkRepository.findAllWithSpeakers();
    // this.talks = this.talkRepository.findAll();
  }

  public List<Talk> getTalks()
  {
    return this.talks;
  }

  Talk talk;

  public Talk getTalk()
  {
    return this.talk;
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
