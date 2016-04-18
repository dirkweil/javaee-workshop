package de.gedoplan.workshop.persistence;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer
{
  @PersistenceContext(unitName = "default")
  EntityManager entityManager;

  @Produces
  // @Default
  public EntityManager getEntityManager()
  {
    return this.entityManager;
  }

  @PersistenceContext(unitName = "temp")
  EntityManager tempEntityManager;

  @Produces
  @TempDb
  public EntityManager getTempEntityManager()
  {
    return this.tempEntityManager;
  }
}
