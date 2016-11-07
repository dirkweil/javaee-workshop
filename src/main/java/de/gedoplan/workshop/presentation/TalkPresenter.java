package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.entity.Talk;
import de.gedoplan.workshop.entity.TalkType;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;

@Named
@FlowScoped("talk")
public class TalkPresenter implements Serializable {

  @Inject
  TalkRepository talkRepository;

  private List<Talk> talks;

  @Getter
  private Talk currentTalk;

  public List<Talk> getTalks() {
    return this.talks;
  }

  public String editTalk(Talk talk) {
    this.currentTalk = talk;
    return "editTalk";
  }

  public String createTalk() {
    this.currentTalk = new Talk(null, null);
    this.talks.add(this.currentTalk);
    return "editTalk";
  }

  public String saveTalk() {
    this.talkRepository.merge(this.currentTalk);
    return "talk";
  }

  @PostConstruct
  void init() {
    System.out.println("####");
    this.talks = this.talkRepository.findAll();
  }

  public TalkType[] getTalkTypes() {
    return TalkType.values();
  }
}
