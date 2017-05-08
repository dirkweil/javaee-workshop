package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.Person;
import de.gedoplan.workshop.persistence.PersonRepository;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;

@Named
@RequestScoped
public class PersonPresenter implements Serializable {
  @Inject
  PersonRepository personRepository;

  @Getter
  private List<Person> persons;

  @PostConstruct
  void postConstruct() {
    this.persons = this.personRepository.findAll();
  }
}
