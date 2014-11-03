package de.gedoplan.workshop.batch;

import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timer;

@Stateless
public class SpecialDayJobControl
{
  @Schedule(hour = "*", minute = "*", second = "0/10")
  public void runImport(Timer timer)
  {
    JobOperator jobOperator = BatchRuntime.getJobOperator();
    Properties jobProperties = new Properties();
    jobOperator.start("specialDayImport", jobProperties);
  }

}
