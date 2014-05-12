package de.gedoplan.workshop.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer
{
  //  @PersistenceContext(unitName = "default")
  //  EntityManager entityManager;
  //
  //  @Produces
  //  @Default
  //  public EntityManager getEntityManager()
  //  {
  //    return this.entityManager;
  //  }

  @PersistenceUnit(unitName = "default")
  EntityManagerFactory entityManagerFactory;

  @Produces
  @Default
  @RequestScoped
  public EntityManager createEntityManager()
  {
    return this.entityManagerFactory.createEntityManager();
  }

  public void closeEntityManager(@Disposes @Default EntityManager entityManager)
  {
    entityManager.close();
  }

}
