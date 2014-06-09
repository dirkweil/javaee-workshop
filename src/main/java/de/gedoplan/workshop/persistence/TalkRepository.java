package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.Talk;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Transactional
public class TalkRepository
{
  @Inject
  EntityManager entityManager;

  public void persist(Talk entity)
  {
    this.entityManager.persist(entity);
  }

  public Talk findById(String id)
  {
    return this.entityManager.find(Talk.class, id);
  }

  public Talk merge(Talk entity)
  {
    return this.entityManager.merge(entity);
  }

  public void remove(Talk entity)
  {
    this.entityManager.remove(entity);
  }

  public List<Talk> findAll()
  {
    TypedQuery<Talk> query = this.entityManager.createQuery("select t from Talk t", Talk.class);
    return query.getResultList();
  }

  public List<Talk> findByInterval(Date min, Date max)
  {
    TypedQuery<Talk> query = this.entityManager.createQuery("select t from Talk t where t.start>=:min and t.start<:max", Talk.class);
    query.setParameter("min", min, TemporalType.TIMESTAMP);
    query.setParameter("max", max, TemporalType.TIMESTAMP);
    return query.getResultList();
  }

  public Talk findNext()
  {
    TypedQuery<Talk> query = this.entityManager.createQuery("select t from Talk t where t.start>=:now order by t.start", Talk.class);
    query.setParameter("now", new Date(), TemporalType.TIMESTAMP);
    query.setMaxResults(1);
    List<Talk> talks = query.getResultList();
    return talks.isEmpty() ? null : talks.get(0);
  }
}
