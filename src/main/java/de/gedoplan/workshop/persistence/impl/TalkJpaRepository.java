package de.gedoplan.workshop.persistence.impl;

import de.gedoplan.baselibs.persistence.repository.SingleIdEntityRepository;
import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.persistence.TalkRepository;

import javax.ejb.Singleton;

//@ApplicationScoped
//@Transactional(rollbackOn = Exception.class)
@Singleton
public class TalkJpaRepository extends SingleIdEntityRepository<Integer, Talk> implements TalkRepository {
  // evtl. weitere Finder
}
