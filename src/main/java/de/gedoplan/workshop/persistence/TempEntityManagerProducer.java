package de.gedoplan.workshop.persistence;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class TempEntityManagerProducer
{
  @PersistenceContext(unitName = "temp")
  EntityManager entityManager;

  @Produces
  @Temp
  public EntityManager getEntityManager()
  {
    return this.entityManager;
  }

}
