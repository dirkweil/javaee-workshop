package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.Person;
import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.domain.TalkType;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import lombok.Getter;
import lombok.Setter;

@Named // ("talkPresenter")
// @SessionScoped
// @FlowScoped("talk")
@ViewAccessScoped
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

  @Inject
  Validator validator;

  public String saveTalk() {
    Set<ConstraintViolation<Talk>> errors = this.validator.validate(this.currentTalk);
    if (!errors.isEmpty()) {
      // Das Objekt ist nicht valide; man könnte eine spezifische Fehlermeldung
      // erzeugen, aber
      // das sei dem Leser als Übung überlassen ;-) (Hinweis: API von
      // ConstraintViolation)
      FacesMessage message = new FacesMessage("Fehler: " + errors);
      message.setSeverity(FacesMessage.SEVERITY_ERROR);
      FacesContext.getCurrentInstance().addMessage(null, message);

      // auf Seite verbleiben
      return null;
    }

    this.talkRepository.merge(this.currentTalk);

    postConstruct();

    return "talk";
  }

  public TalkType[] getTalkTypes() {
    return TalkType.values();
  }

  @Getter
  @Inject
  List<Person> allSpeakers;

  @Getter
  @Setter
  Person additionalSpeaker;

  public void addSpeaker() {
    this.currentTalk.getSpeakers().add(this.additionalSpeaker);
  }

}
