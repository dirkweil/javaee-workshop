package de.gedoplan.workshop.cman.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SpecialDay
{
  @Id
  private String id;
  private String name;

  public SpecialDay(String id, String name)
  {
    this.id = id;
    this.name = name;
  }

  protected SpecialDay()
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

  public String getId()
  {
    return this.id;
  }

}
