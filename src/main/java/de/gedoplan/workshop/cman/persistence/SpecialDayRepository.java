package de.gedoplan.workshop.cman.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

//@ApplicationScoped
//@Transactional()
@Stateless
@TransactionAttribute()
public class SpecialDayRepository
{
  @Inject
  @Default
  EntityManager entityManager;

  public void persist(SpecialDay entity)
  {
    this.entityManager.persist(entity);
  }

  public SpecialDay merge(SpecialDay entity)
  {
    return this.entityManager.merge(entity);
  }

  public void remove(SpecialDay entity)
  {
    this.entityManager.remove(entity);
  }

  public SpecialDay findById(String id)
  {
    return this.entityManager.find(SpecialDay.class, id);
  }

  @Produces
  @All
  public List<SpecialDay> findAll()
  {
    return this.entityManager.createQuery("select x from SpecialDay as x", SpecialDay.class).getResultList();
  }

}
