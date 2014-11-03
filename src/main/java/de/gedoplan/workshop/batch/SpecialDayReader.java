package de.gedoplan.workshop.batch;

import de.gedoplan.workshop.domain.SpecialDay;

import java.io.BufferedReader;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import javax.batch.api.chunk.ItemReader;
import javax.inject.Named;

@Named
public class SpecialDayReader implements ItemReader
{
  private static final String FILE_NAME = "c:\\data\\temp\\specialday.csv";

  private BufferedReader      bufferedReader;

  @Override
  public void open(Serializable checkpoint) throws Exception
  {
    this.bufferedReader = Files.newBufferedReader(FileSystems.getDefault().getPath(FILE_NAME));
  }

  @Override
  public void close() throws Exception
  {
    this.bufferedReader.close();
  }

  @Override
  public SpecialDay readItem() throws Exception
  {
    String line = this.bufferedReader.readLine();
    if (line == null)
    {
      return null;
    }

    String[] part = line.split("\\t", 2);
    SpecialDay specialDay = new SpecialDay(part[0], part[1]);
    return specialDay;
  }

  @Override
  public Serializable checkpointInfo() throws Exception
  {
    return null;
  }

}
