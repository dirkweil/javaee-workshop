package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.qualifier.Temp;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@RequestScoped
@Stateful
public class EntityManagerProducer
{
  @PersistenceContext(unitName = "default", type = PersistenceContextType.EXTENDED)
  EntityManager entityManager;

  @Produces
  @RequestScoped
  public EntityManager getEntityManager()
  {
    return this.entityManager;
  }

  @PersistenceContext(unitName = "temp")
  EntityManager tempEntityManager;

  @Produces
  @Temp
  @RequestScoped
  public EntityManager getTempEntityManager()
  {
    return this.tempEntityManager;
  }
}
