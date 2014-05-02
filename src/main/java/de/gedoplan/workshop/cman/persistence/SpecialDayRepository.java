package de.gedoplan.workshop.cman.persistence;

import de.gedoplan.workshop.cman.entity.SpecialDay;
import de.gedoplan.workshop.cman.qualifier.All;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class SpecialDayRepository extends SingleIdEntityRepository<String, SpecialDay>
{
  @Override
  @Produces
  @All
  public List<SpecialDay> findAll()
  {
    return super.findAll();
  }

}
