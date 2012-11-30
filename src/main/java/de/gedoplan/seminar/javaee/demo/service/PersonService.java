package de.gedoplan.seminar.javaee.demo.service;

import de.gedoplan.seminar.javaee.demo.entity.Person;
import de.gedoplan.seminar.javaee.demo.repository.PersonRepository;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PersonService implements Serializable
{
  @Inject
  PersonRepository personRepository;

  public void createPersons(int count)
  {
    for (int i = 0; i < count; ++i)
    {
      Person person = new Person("Testperson " + i);
      this.personRepository.save(person);
    }
  }
}
