package de.gedoplan.workshop.cman.persistence;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional()
//@Stateless
//@TransactionAttribute()
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
