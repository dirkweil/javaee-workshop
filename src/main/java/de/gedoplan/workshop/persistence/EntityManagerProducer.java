package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.qualifier.Temp;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer
{
  @PersistenceContext(unitName = "default")
  EntityManager entityManager;

  @Produces
  @Default
  EntityManager getEntityManager()
  {
    return this.entityManager;
  }

  @PersistenceContext(unitName = "temp")
  EntityManager tempEntityManager;

  @Produces
  @Temp
  EntityManager getTempEntityManager()
  {
    return this.tempEntityManager;
  }
}
