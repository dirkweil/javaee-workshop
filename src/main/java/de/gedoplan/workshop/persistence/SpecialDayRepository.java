package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.SpecialDay;

import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

// TODO: TX-Steuerung?
public class SpecialDayRepository
{
  // @PersistenceContext(unitName = "default")
  @Inject
  EntityManager entityManager;

  public void persist(SpecialDay specialDay)
  {
    this.entityManager.persist(specialDay);
  }

  @Produces
  @All
  public List<SpecialDay> findAll()
  {
    TypedQuery<SpecialDay> query = this.entityManager.createQuery("select x from SpecialDay x", SpecialDay.class);
    return query.getResultList();
  }

}
