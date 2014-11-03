package de.gedoplan.workshop.batch;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import java.io.Serializable;
import java.util.List;

import javax.batch.api.chunk.ItemWriter;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
/*
 * FIXED: Dieser ItemWriter nutzt einen Entity Manager im Request Scope. Dieser Scope ist aber
 * im Kontext eines Batches nicht gestartet. Durch Implementierung des Writers als EJB wird dies
 * vom EJB Container erledigt: Der startet lt. Spezifikation sowohl den Request Scope wie auch den
 * Application Scope.
 */
@Stateless
/*
 * FIXED: EJBs unterscheiden sich von CDI Beans hinsichtlich ihrer Sichtbarkeit in Bezug auf Injektion.
 * Soll die EJB als Klasse in ein Injektionsziel (mittels @Inject) geschrieben werden, muss dies mit
 * 
 * @LocalBean angemeldet werden. Ohne dies wären nur die lokalen Interfaces injizierbar.
 */
@LocalBean
public class SpecialDayWriter implements ItemWriter
{
  @Inject
  SpecialDayRepository specialDayRepository;

  @Override
  public void open(Serializable checkpoint) throws Exception
  {
  }

  @Override
  public void close() throws Exception
  {
  }

  @Override
  @Transactional
  public void writeItems(List<Object> items) throws Exception
  {
    for (Object item : items)
    {
      if (item instanceof SpecialDay)
      {
        this.specialDayRepository.merge((SpecialDay) item);
      }
    }
  }

  @Override
  public Serializable checkpointInfo() throws Exception
  {
    return null;
  }

}
