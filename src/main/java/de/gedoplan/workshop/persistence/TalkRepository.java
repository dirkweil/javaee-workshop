package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.Talk;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class TalkRepository implements Serializable
{
  @PersistenceContext(unitName = "default")
  EntityManager entityManager;

  public void persist(Talk talk)
  {
    this.entityManager.persist(talk);
  }

  public void merge(Talk talk)
  {
    this.entityManager.merge(talk);
  }

  public void remove(Talk talk)
  {
    this.entityManager.remove(talk);
  }

  public Talk findById(Integer id)
  {
    return this.entityManager.find(Talk.class, id);
  }

  public List<Talk> findAll()
  {
    return this.entityManager.createQuery("select x from Talk x", Talk.class).getResultList();
  }

}
