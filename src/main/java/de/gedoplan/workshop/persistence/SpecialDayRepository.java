package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.SpecialDay;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Transactional
public class SpecialDayRepository
{
  @Inject
  EntityManager entityManager;

  public void persist(SpecialDay entity)
  {
    this.entityManager.persist(entity);
  }

  public SpecialDay findById(String id)
  {
    return this.entityManager.find(SpecialDay.class, id);
  }

  public SpecialDay merge(SpecialDay entity)
  {
    return this.entityManager.merge(entity);
  }

  public void remove(SpecialDay entity)
  {
    this.entityManager.remove(entity);
  }

  public List<SpecialDay> findAll()
  {
    TypedQuery<SpecialDay> query = this.entityManager.createQuery("select sd from SpecialDay sd", SpecialDay.class);
    return query.getResultList();
  }
}
