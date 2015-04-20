package de.gedoplan.workshop.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.FIELD)
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
