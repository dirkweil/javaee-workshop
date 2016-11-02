package de.gedoplan.workshop.service;

import de.gedoplan.workshop.entity.Dummy;
import de.gedoplan.workshop.persistence.DummyRepository;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@ApplicationScoped
public class InitDummyDataService implements Serializable
{
  @Inject
  DummyRepository    currencyRepository;

  private static Log log = LogFactory.getLog(InitDummyDataService.class);

  @Transactional
  void createDemoData(@Observes @Initialized(ApplicationScoped.class) Object event)
  {
    try
    {
      if (this.currencyRepository.countAll() == 0)
      {
        for (int i = 1; i <= 10; ++i)
        {
          this.currencyRepository.merge(new Dummy(String.format("Dummy %03d", i)));
        }
      }
    }
    catch (Exception e)
    {
      log.warn("Cannot create test data", e);
    }
  }
}
