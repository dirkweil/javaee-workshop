package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.Talk;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityGraph;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TalkRepository extends SingleIdEntityRepository<Integer, Talk>
{

  public List<Talk> findAllWithSpeakers()
  {
    // return this.entityManager.createQuery("select distinct t from Talk t left join fetch t.speakers",
    // Talk.class).getResultList();

    // EntityGraph<?> entityGraph = this.entityManager.getEntityGraph("TalksWithSpeakers");

    EntityGraph<Talk> entityGraph = this.entityManager.createEntityGraph(Talk.class);
    entityGraph.addAttributeNodes("speakers");

    return this.entityManager.createQuery("select distinct x from Talk x", Talk.class).setHint("javax.persistence.loadgraph", entityGraph).getResultList();
  }

  public List<IdAndName> findAllReduced()
  {
    return this.entityManager.createQuery("select new de.gedoplan.workshop.persistence.IdAndName(t.id, t.title) from Talk t", IdAndName.class).getResultList();
  }

}
