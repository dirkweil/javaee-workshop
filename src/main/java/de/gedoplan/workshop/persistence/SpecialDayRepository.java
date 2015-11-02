package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.SpecialDay;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class SpecialDayRepository
{
  @Inject
  @Default
  EntityManager entityManager;

  public void persist(SpecialDay specialDay)
  {
    this.entityManager.persist(specialDay);
  }

  public SpecialDay findById(String id)
  {
    return this.entityManager.find(SpecialDay.class, id);
  }

  @Produces
  public List<SpecialDay> findAll()
  {
    return this.entityManager
        .createQuery("select s from SpecialDay as s", SpecialDay.class)
        .getResultList();
  }

}
