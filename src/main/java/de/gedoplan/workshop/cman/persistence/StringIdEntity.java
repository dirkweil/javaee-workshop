package de.gedoplan.workshop.cman.persistence;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class StringIdEntity extends SingleIdEntity<String>
{
  @Id
  private String id;

  protected StringIdEntity(String id)
  {
    this.id = id;
  }

  protected StringIdEntity()
  {
  }

  @Override
  public String getId()
  {
    return this.id;
  }

  public void setId(String id)
  {
    this.id = id;
  }
}
