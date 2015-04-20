package de.gedoplan.workshop.persistence;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer
{
  @PersistenceContext(unitName = "default")
  EntityManager entityManager;

  @Produces
  public EntityManager getEntityManager()
  {
    return this.entityManager;
  }
}
