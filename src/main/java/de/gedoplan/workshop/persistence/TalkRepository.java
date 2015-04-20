package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.Talk;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class TalkRepository extends SingleIdEntityRepository<Integer, Talk>
{
}
