package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.SpecialDay;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Transactional
public class SpecialDayRepository implements Serializable
{
  // @PersistenceContext(unitName = "default")
  @Inject
  EntityManager entityManager;

  public void persist(SpecialDay specialDay)
  {
    this.entityManager.persist(specialDay);
  }

  public void merge(SpecialDay specialDay)
  {
    this.entityManager.merge(specialDay);
  }

  @Produces
  @All
  public List<SpecialDay> findAll()
  {
    TypedQuery<SpecialDay> query = this.entityManager.createQuery("select x from SpecialDay x", SpecialDay.class);
    return query.getResultList();
  }

  public SpecialDay findById(String id)
  {
    return this.entityManager.find(SpecialDay.class, id);
  }

}
