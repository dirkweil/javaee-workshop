package de.gedoplan.workshop.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SpecialDay implements Serializable
{
  @Id
  private String id;
  private String name;

  public SpecialDay(String id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public String getId()
  {
    return this.id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override
  public String toString()
  {
    return "SpecialDay [id=" + this.id + ", name=" + this.name + "]";
  }

  protected SpecialDay()
  {
  }
}
