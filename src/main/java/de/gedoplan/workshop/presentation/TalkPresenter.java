package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.entity.Talk;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class TalkPresenter {

  @Inject
  TalkRepository talkRepository;

  private List<Talk> talks;

  public List<Talk> getTalks() {
    return this.talks;
  }

  @PostConstruct
  void init() {
    System.out.println("####");
    this.talks = this.talkRepository.findAll();
  }
}
