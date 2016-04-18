package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.Talk;

import javax.enterprise.context.Dependent;

@Dependent
public class TalkRepository extends SingleIdEntityRepository<Integer, Talk>
{

}
