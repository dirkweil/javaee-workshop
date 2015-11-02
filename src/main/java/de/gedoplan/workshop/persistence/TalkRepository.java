package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.Talk;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.transaction.Transactional;

@Transactional
public class TalkRepository extends SingleIdEntityRepository<Integer, Talk>
{
  public List<Talk> findTalksWithSpeakers()
  {
    EntityGraph<?> entityGraph = this.entityManager.getEntityGraph("TalksWithSpeakers");

    return this.entityManager
        .createQuery("select distinct x from Talk x", Talk.class)
        .setHint("javax.persistence.loadgraph", entityGraph)
        .getResultList();
  }

}
