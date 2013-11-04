package de.gedoplan.workshop.cman.persistence;

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
public class RequestScopedEntityManagerProducer
{
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
