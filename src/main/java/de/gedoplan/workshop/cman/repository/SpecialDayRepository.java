package de.gedoplan.workshop.cman.repository;

import de.gedoplan.workshop.cman.entity.SpecialDay;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class SpecialDayRepository
{
  @PersistenceContext(unitName = "default")
  EntityManager entityManager;

  public void persist(SpecialDay entity)
  {
    this.entityManager.persist(entity);
  }

  public SpecialDay merge(SpecialDay entity)
  {
    return this.entityManager.merge(entity);
  }

  public void remove(SpecialDay entity)
  {
    this.entityManager.remove(entity);
  }

  public SpecialDay findById(String id)
  {
    return this.entityManager.find(SpecialDay.class, id);
  }

  public List<SpecialDay> findAll()
  {
    return this.entityManager.createQuery("select x from SpecialDay x", SpecialDay.class).getResultList();
  }

}
