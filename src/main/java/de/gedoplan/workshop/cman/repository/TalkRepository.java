package de.gedoplan.workshop.cman.repository;

import de.gedoplan.workshop.cman.entity.Talk;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TalkRepository extends SingleIdEntityRepository<Integer, Talk>
{

}
