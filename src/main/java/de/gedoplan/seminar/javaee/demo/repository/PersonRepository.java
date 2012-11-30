package de.gedoplan.seminar.javaee.demo.repository;

import de.gedoplan.seminar.javaee.demo.entity.Person;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PersonRepository implements Serializable
{
  @PersistenceContext
  EntityManager entityManager;

  @TransactionAttribute(TransactionAttributeType.SUPPORTS)
  public Person findById(Integer id)
  {
    return this.entityManager.find(Person.class, id);
  }

  @TransactionAttribute(TransactionAttributeType.SUPPORTS)
  public List<Person> findAll()
  {
    TypedQuery<Person> query = this.entityManager.createQuery("select p from Person p", Person.class);
    return query.getResultList();
  }

  public void save(Person person)
  {
    this.entityManager.merge(person);
  }

}
