package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.SpecialDay;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class SpecialDayRepository implements Serializable
{
  // @PersistenceContext(unitName = "default")
  @Inject
  @Default
  EntityManager entityManager;

  public void persist(SpecialDay specialDay)
  {
    this.entityManager.persist(specialDay);
  }

  public void merge(SpecialDay specialDay)
  {
    this.entityManager.merge(specialDay);
  }

  public void remove(SpecialDay specialDay)
  {
    this.entityManager.remove(specialDay);
  }

  public SpecialDay findById(String id)
  {
    return this.entityManager.find(SpecialDay.class, id);
  }

  @Produces
  public List<SpecialDay> findAll()
  {
    return this.entityManager.createQuery("select s from SpecialDay s", SpecialDay.class).getResultList();
  }

}
