package de.gedoplan.workshop.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer
{
  @PersistenceContext(unitName = "default")
  @Produces
  EntityManager entityManager;

  // private EntityManager getEntityManager()
  // {
  // return this.entityManager;
  // }

  // @PersistenceContext(unitName = "test")
  // @Produces
  // @Test
  // EntityManager testEntityManager;

}
