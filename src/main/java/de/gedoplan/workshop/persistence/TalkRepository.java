package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.Talk;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TalkRepository extends SingleIdEntityRepository<Integer, Talk>
{

  public List<Talk> findAllWithSpeakers()
  {
    return this.entityManager.createQuery("select distinct t from Talk t left join fetch t.speakers", Talk.class).getResultList();
  }

}
