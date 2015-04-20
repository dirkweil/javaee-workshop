package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.SpecialDay;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class SpecialDayRepository extends SingleIdEntityRepository<String, SpecialDay>
{
  @Produces
  public List<SpecialDay> findAll()
  {
    return super.findAll();
  }

}
