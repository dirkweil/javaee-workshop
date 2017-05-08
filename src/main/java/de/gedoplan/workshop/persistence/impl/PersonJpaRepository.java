package de.gedoplan.workshop.persistence.impl;

import de.gedoplan.baselibs.persistence.repository.SingleIdEntityRepository;
import de.gedoplan.workshop.domain.Person;
import de.gedoplan.workshop.persistence.PersonRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonJpaRepository extends SingleIdEntityRepository<Integer, Person> implements PersonRepository {
  // evtl. weitere Finder
}
