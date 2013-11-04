package de.gedoplan.workshop.cman.persistence;

import javax.persistence.Entity;

@Entity
public class SpecialDay extends StringIdEntity
{
  private String name;

  public SpecialDay(String id, String name)
  {
    super(id);
    this.name = name;
  }

  public SpecialDay()
  {
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

}
