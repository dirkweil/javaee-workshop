package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.entity.Talk;

import java.util.List;

public interface TalkRepository {
  List<Talk> findAll();

  Talk findById(Integer id);

  void persist(Talk talk);

  Talk merge(Talk talk);
}
