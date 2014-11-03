package de.gedoplan.workshop.batch;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import java.io.Serializable;
import java.util.List;

import javax.batch.api.chunk.ItemWriter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
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
