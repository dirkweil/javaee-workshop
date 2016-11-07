package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.entity.Person;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class PersonJpaRepository implements PersonRepository {

  @Inject
  EntityManager entityManager;

  @Override
  public List<Person> findAll() {
    return this.entityManager.createQuery("select x from Person x", Person.class).getResultList();
  }

  @Override
  public Person findById(Integer id) {
    return this.entityManager.find(Person.class, id);
  }

  @Override
  public void persist(Person person) {
    this.entityManager.persist(person);
  }

  @Override
  public Person merge(Person person) {
    return this.entityManager.merge(person);
  }
}
