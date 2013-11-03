package de.gedoplan.workshop.cman.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GeneratedIntegerIdEntity extends SingleIdEntity<Integer>
{
  @Id
  @GeneratedValue
  private Integer id;

  protected GeneratedIntegerIdEntity()
  {
  }

  @Override
  public Integer getId()
  {
    return this.id;
  }

}
