package de.gedoplan.workshop.persistence.impl;

import de.gedoplan.workshop.domain.Person;
import de.gedoplan.workshop.persistence.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.persistence.PersistenceException;

@ApplicationScoped
@Alternative
public class PersonMockRepository implements PersonRepository {

  private ConcurrentHashMap<Integer, Person> store = new ConcurrentHashMap<>();
  private AtomicInteger idGenerator = new AtomicInteger();

  protected PersonMockRepository() {
    persist(new Person("Weil", "Dirk"));
    persist(new Person("Meyen", "Sebastian"));
  }

  @Produces
  @Override
  public List<Person> findAll() {
    return new ArrayList<>(this.store.values());
  }

  @Override
  public Person findById(Integer id) {
    return this.store.get(id);
  }

  @Override
  public void persist(Person person) {
    if (person.getId() != null) {
      throw new PersistenceException("id already set");
    }

    person.setId(this.idGenerator.incrementAndGet());
    this.store.put(person.getId(), person);
  }

  @Override
  public Person merge(Person person) {
    if (person.getId() == null) {
      persist(person);
    } else {
      this.store.put(person.getId(), person);
    }
    return person;
  }

}
