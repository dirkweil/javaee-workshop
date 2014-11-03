package de.gedoplan.workshop.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
// @Table(name="SPECIAL_DAY")
public class SpecialDay
{
  @Id
  private String id;

  // @Column(name = "NAME", columnDefinition = "VARCHAR(30)")
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

  public void setId(String id)
  {
    this.id = id;
  }

  @Override
  public String toString()
  {
    return "SpecialDay [id=" + this.id + ", name=" + this.name + "]";
  }

}
