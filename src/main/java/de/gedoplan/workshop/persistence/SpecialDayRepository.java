package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.SpecialDay;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

// TODO: TX-Steuerung?
public class SpecialDayRepository
{
  @PersistenceContext(unitName = "default")
  EntityManager entityManager;

  public void persist(SpecialDay specialDay)
  {
    this.entityManager.persist(specialDay);
  }

  public List<SpecialDay> findAll()
  {
    TypedQuery<SpecialDay> query = this.entityManager.createQuery("select x from SpecialDay x", SpecialDay.class);
    return query.getResultList();
  }

}
