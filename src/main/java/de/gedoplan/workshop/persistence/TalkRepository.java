package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.Talk;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Transactional
public class TalkRepository implements Serializable
{
  @Inject
  EntityManager entityManager;

  public void persist(Talk Talk)
  {
    /*
     * FIXED: Bei Nutzung eines Application Managed Entity Managers muss die Verbindung zur Transaktion explizit gemacht werden.
     * Ohne dies speicher der EM nichts ab!
     */
    this.entityManager.joinTransaction();
    this.entityManager.persist(Talk);
  }

  public void merge(Talk Talk)
  {
    /*
     * FIXED: Bei Nutzung eines Application Managed Entity Managers muss die Verbindung zur Transaktion explizit gemacht werden.
     * Ohne dies speicher der EM nichts ab!
     */
    this.entityManager.joinTransaction();
    this.entityManager.merge(Talk);
  }

  @Produces
  @All
  public List<Talk> findAll()
  {
    TypedQuery<Talk> query = this.entityManager.createQuery("select x from Talk x", Talk.class);
    return query.getResultList();
  }

}
