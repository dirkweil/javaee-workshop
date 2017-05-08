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
import javax.transaction.Transactional;

import lombok.Getter;

@Named // ("talkPresenter")
@SessionScoped
@Transactional(rollbackOn = Exception.class)
public class TalkPresenter implements Serializable {

  @Inject
  TalkRepository talkRepository;

  @PostConstruct
  void postConstruct() {
    this.talks = this.talkRepository.findAll();
  }

  private List<Talk> talks;

  public List<Talk> getTalks() {
    return this.talks;
  }

  @Getter
  Talk currentTalk;

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

    postConstruct();

    return "talk";
  }

  public TalkType[] getTalkTypes() {
    return TalkType.values();
  }
}
