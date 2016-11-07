package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.entity.Talk;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class TalkJpaRepository implements TalkRepository {

  @Inject
  EntityManager entityManager;

  @Override
  public List<Talk> findAll() {
    return this.entityManager.createQuery("select x from Talk x", Talk.class).getResultList();
    // return this.entityManager.createNamedQuery("talk.all",
    // Talk.class).getResultList();
  }

  @Override
  public Talk findById(Integer id) {
    return this.entityManager.find(Talk.class, id);
  }

  @Override
  public void persist(Talk talk) {
    this.entityManager.persist(talk);
  }

  @Override
  public Talk merge(Talk talk) {
    return this.entityManager.merge(talk);
  }
}
