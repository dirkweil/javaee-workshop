package de.gedoplan.workshop.cman.persistence;

import de.gedoplan.workshop.cman.qualifier.TempDb;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer
{
  @PersistenceContext(unitName = "default")
  @Produces
  @Default
  EntityManager entityManager;

  //  @Produces
  //  public EntityManager getEntityManager()
  //  {
  //    return this.entityManager;
  //  }

  @PersistenceContext(unitName = "temp")
  @Produces
  @TempDb
  EntityManager tempEntityManager;

}
