package de.gedoplan.workshop.persistence;

import de.gedoplan.baselibs.persistence.repository.SingleIdEntityRepository;
import de.gedoplan.workshop.entity.Talk;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TalkJpaRepository extends SingleIdEntityRepository<Integer, Talk> implements TalkRepository {
}
