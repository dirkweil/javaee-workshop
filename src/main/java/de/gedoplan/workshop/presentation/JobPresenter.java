package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.batch.SpecialDayJobControl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class JobPresenter
{
  @Inject
  SpecialDayJobControl specialDayJobControl;

  public void runSpecialDayImport()
  {
    this.specialDayJobControl.runImport();
  }

}
