package de.gedoplan.workshop.persistence.impl;

import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.domain.TalkType;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.persistence.PersistenceException;

@ApplicationScoped
@Alternative
public class TalkMockRepository implements TalkRepository {

  private Map<Integer, Talk> mockTable = new ConcurrentHashMap<>();
  private AtomicInteger idGenerator = new AtomicInteger(1);

  @PostConstruct
  void postConstruct() {
    persist(new Talk("Java EE ohne Ballast", TalkType.WORKSHOP));
    persist(new Talk("Eroeffnung", TalkType.KEYNOTE));
    persist(new Talk("Docker", TalkType.SESSION));
  }

  @Override
  public void persist(Talk talk) {
    if (talk.getId() != null) {
      throw new PersistenceException("id already set");
    }

    talk.setId(this.idGenerator.getAndIncrement());
    this.mockTable.put(talk.getId(), talk);
  }

  @Override
  public Talk merge(Talk talk) {
    if (talk.getId() == null) {
      persist(talk);
    } else {
      this.mockTable.put(talk.getId(), talk);
    }
    return talk;
  }

  @Override
  public Talk findById(Integer id) {
    return this.mockTable.get(id);
  }

  @Override
  public List<Talk> findAll() {
    return new ArrayList<>(this.mockTable.values());
  }

}
