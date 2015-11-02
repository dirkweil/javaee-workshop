package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.Talk;

import javax.transaction.Transactional;

@Transactional
public class TalkRepository extends SingleIdEntityRepository<Integer, Talk>
{

}
