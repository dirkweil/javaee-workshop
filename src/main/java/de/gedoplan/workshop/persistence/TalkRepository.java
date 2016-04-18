package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.Talk;

import javax.enterprise.context.Dependent;
import javax.transaction.Transactional;

@Dependent
@Transactional
public class TalkRepository extends SingleIdEntityRepository<Integer, Talk>
{

}
