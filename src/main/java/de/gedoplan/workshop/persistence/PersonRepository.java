package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.Person;

import java.util.List;

public interface PersonRepository {
  List<Person> findAll();

  Person findById(Integer id);

  void persist(Person person);

  Person merge(Person person);
}
