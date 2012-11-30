package de.gedoplan.seminar.javaee.demo.model;

import de.gedoplan.seminar.javaee.demo.entity.Person;
import de.gedoplan.seminar.javaee.demo.repository.PersonRepository;
import de.gedoplan.seminar.javaee.demo.service.PersonService;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
@ConversationScoped
// @Named
// @RequestScoped
public class PersonModel implements Serializable
{
  @Inject
  PersonRepository personRepository;

  @Inject
  PersonService    personService;

  @Inject
  Conversation     conversation;

  private Person   currentPerson;

  public List<Person> getPersonen()
  {
    return this.personRepository.findAll();
  }

  public Person getCurrentPerson()
  {
    return this.currentPerson;
  }

  public void edit(Person person)
  {
    this.currentPerson = person;

    if (this.conversation.isTransient())
    {
      this.conversation.begin();
    }
  }

  public void save()
  {
    this.personRepository.save(this.currentPerson);

    this.currentPerson = null;

    if (!this.conversation.isTransient())
    {
      this.conversation.end();
    }
  }

  public void cancel()
  {
    this.currentPerson = null;

    if (!this.conversation.isTransient())
    {
      this.conversation.end();
    }
  }

  public void create10Persons()
  {
    this.personService.createPersons(10);
  }

}
