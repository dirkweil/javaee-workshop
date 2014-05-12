package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.qualifier.Temp;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
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
