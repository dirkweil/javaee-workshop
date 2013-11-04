package de.gedoplan.workshop.cman.persistence;

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
  private EntityManager entityManager;

  @PersistenceContext(unitName = "temp")
  @Produces
  @TempDb
  private EntityManager entityManager2;

}
