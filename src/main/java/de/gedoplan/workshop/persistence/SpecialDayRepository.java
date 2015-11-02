package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.SpecialDay;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SpecialDayRepository
{
  @PersistenceContext(unitName = "default")
  EntityManager entityManager;

  public void persist(SpecialDay specialDay)
  {
    this.entityManager.persist(specialDay);
  }

  public SpecialDay findById(String id)
  {
    return this.entityManager.find(SpecialDay.class, id);
  }

  public List<SpecialDay> findAll()
  {
    return this.entityManager
        .createQuery("select s from SpecialDay as s", SpecialDay.class)
        .getResultList();
  }

}
