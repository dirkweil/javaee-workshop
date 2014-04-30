package de.gedoplan.workshop.cman.repository;

import de.gedoplan.workshop.cman.entity.FertigungsAuftrag;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class FertigungsauftragRepository
{
  @PersistenceContext(unitName = "default")
  EntityManager entityManager;

  public List<FertigungsAuftrag> findAll()
  {
    TypedQuery<FertigungsAuftrag> query = this.entityManager.createQuery("select f from FertigungsAuftrag f", FertigungsAuftrag.class);
    return query.getResultList();
  }

}
