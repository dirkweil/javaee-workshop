package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.Schiff;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class SchiffRepository implements Serializable
{
  @PersistenceContext(unitName = "default")
  EntityManager entityManager;

  public List<Schiff> findAll()
  {
    return this.entityManager.createQuery("select s from Schiff s", Schiff.class).getResultList();
  }

  public Schiff findById(Integer id)
  {
    return this.entityManager.find(Schiff.class, id);
  }

  @Transactional
  public void save(Schiff schiff)
  {
    this.entityManager.merge(schiff);
  }
}
