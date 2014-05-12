package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.qualifier.All;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@ApplicationScoped
//@Stateless
@Transactional(value = TxType.REQUIRED)
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
