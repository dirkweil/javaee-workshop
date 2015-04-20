package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.Talk;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityGraph;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class TalkRepository extends SingleIdEntityRepository<Integer, Talk>
{

  public List<Talk> findAllWithSpeakers()
  {
    EntityGraph<Talk> entityGraph = this.entityManager.createEntityGraph(Talk.class);
    entityGraph.addAttributeNodes("speakers");

    return this.entityManager.createQuery("select x from Talk x", Talk.class)
        .setHint("javax.persistence.loadgraph", entityGraph)
        .getResultList();
  }
}
