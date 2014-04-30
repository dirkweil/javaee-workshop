package de.gedoplan.workshop.cman.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FertigungsAuftrag
{
  @Id
  long   id;
  String name;
  long   menge;

  public FertigungsAuftrag(long id, String name, long menge)
  {
    this.id = id;
    this.name = name;
    this.menge = menge;
  }

  protected FertigungsAuftrag()
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

  public long getMenge()
  {
    return this.menge;
  }

  public void setMenge(long menge)
  {
    this.menge = menge;
  }

  public long getId()
  {
    return this.id;
  }

}
