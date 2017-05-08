package de.gedoplan.workshop.persistence.impl;

import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class TalkJpaRepository implements TalkRepository {

  @PersistenceContext(unitName = "default")
  EntityManager entityManager;

  @Override
  public void persist(Talk talk) {
    this.entityManager.persist(talk);
  }

  @Override
  public Talk merge(Talk talk) {
    return this.entityManager.merge(talk);
  }

  @Override
  public Talk findById(Integer id) {
    return this.entityManager.find(Talk.class, id);
  }

  @Override
  public List<Talk> findAll() {
    return this.entityManager.createQuery("select t from Talk t", Talk.class).getResultList();
  }

}
