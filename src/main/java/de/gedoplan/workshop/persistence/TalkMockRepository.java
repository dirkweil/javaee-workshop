package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.entity.Talk;
import de.gedoplan.workshop.entity.TalkType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.PersistenceException;

@ApplicationScoped
public class TalkMockRepository implements TalkRepository {

  private ConcurrentHashMap<Integer, Talk> store = new ConcurrentHashMap<>();
  private AtomicInteger idGen = new AtomicInteger();

  @PostConstruct
  void init() {
    persist(new Talk("Java EE ohne Ballast", TalkType.WORKSHOP));
    persist(new Talk("Eroeffnung", TalkType.KEYNOTE));
    persist(new Talk("JS ist toll", TalkType.SESSION));
  }

  @Override
  public List<Talk> findAll() {
    return new ArrayList<>(this.store.values());
  }

  @Override
  public Talk findById(Integer id) {
    return this.store.get(id);
  }

  @Override
  public void persist(Talk talk) {
    if (talk.getId() != null) {
      throw new PersistenceException("id already set");
    }

    talk.setId(this.idGen.getAndIncrement());
    this.store.put(talk.getId(), talk);
  }

  @Override
  public Talk merge(Talk talk) {
    if (talk.getId() == null) {
      persist(talk);
    } else {
      this.store.put(talk.getId(), talk);
    }

    return talk;
  }

}
