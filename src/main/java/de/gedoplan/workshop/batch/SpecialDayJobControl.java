package de.gedoplan.workshop.batch;

import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;

public class SpecialDayJobControl
{
  public void runImport()
  {
    JobOperator jobOperator = BatchRuntime.getJobOperator();
    Properties jobProperties = new Properties();
    jobOperator.start("specialDayImport", jobProperties);
  }

}
