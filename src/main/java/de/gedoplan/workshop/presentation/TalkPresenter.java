package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
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
    // this.talks = this.talkRepository.findAllWithSpeakers();
    this.talks = this.talkRepository.findAll();
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
    /*
     * Achtung: Wir arbeiten mit detached Objects: Die von der View hierhin übergebenen Objekte
     * stammen aus einem früheren Request und sind somit nicht mehr mit dem Entity Manager
     * verbunden. Um ein Nachladen von lazy Attributes zu ermöglichen, wird hier einmal neu gelesen.
     */
    this.talk = this.talkRepository.findById(talk.getId());
    return "talkEdit";
  }

  public String createTalk()
  {
    this.talk = new Talk(null, null, null, null);
    return "talkEdit";
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

  @Inject
  List<SpecialDay> specialDays;

  public List<SpecialDay> getSpecialDays()
  {
    return this.specialDays;
  }

}
