package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.Talk;

import java.util.List;

public interface TalkRepository {
  void persist(Talk talk);

  Talk merge(Talk talk);

  Talk findById(Integer id);

  List<Talk> findAll();
}
