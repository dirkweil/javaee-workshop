package de.gedoplan.workshop.persistence;

import de.gedoplan.baselibs.persistence.repository.SingleIdEntityRepository;
import de.gedoplan.workshop.entity.Person;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonJpaRepository extends SingleIdEntityRepository<Integer, Person> implements PersonRepository {
}
