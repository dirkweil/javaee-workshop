package de.gedoplan.workshop;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import de.gedoplan.workshop.entity.Dummy;

import org.junit.Test;

public class DummyTest
{
  @Test
  public void testDummy() throws Exception
  {
    Dummy dummy = new Dummy("Dummy");
    assertThat(dummy.getName(), is("Dummy"));
  }

}
