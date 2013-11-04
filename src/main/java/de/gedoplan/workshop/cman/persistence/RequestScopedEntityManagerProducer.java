package de.gedoplan.workshop.cman.persistence;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
@Alternative
@Priority(1000)
public class RequestScopedEntityManagerProducer
{
  //  @PersistenceContext(unitName = "default", synchronization=SynchronizationType.UNSYNCHRONIZED)
  //  EntityManager entityManager;

  @PersistenceUnit(unitName = "default")
  EntityManagerFactory entityManagerFactory;

  @Produces
  @RequestScoped
  public EntityManager createEntityManager()
  {
    return this.entityManagerFactory.createEntityManager();
  }

  public void disposeEntityManager(@Disposes EntityManager entityManager)
  {
    entityManager.close();
  }

}
