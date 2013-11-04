package de.gedoplan.workshop.cman.persistence;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TalkRepository extends SingleIdEntityRepository<Integer, Talk>
{
}
