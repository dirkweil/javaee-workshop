package de.gedoplan.workshop.persistence.impl;

import de.gedoplan.baselibs.persistence.repository.SingleIdEntityRepository;
import de.gedoplan.workshop.domain.Person;
import de.gedoplan.workshop.persistence.PersonRepository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class PersonJpaRepository extends SingleIdEntityRepository<Integer, Person> implements PersonRepository {

  @Produces
  @Override
  public List<Person> findAll() {
    return super.findAll();
  }
  // evtl. weitere Finder

}
