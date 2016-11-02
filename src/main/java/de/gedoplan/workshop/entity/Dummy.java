package de.gedoplan.workshop.entity;

import de.gedoplan.baselibs.persistence.entity.GeneratedLongIdEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Dummy extends GeneratedLongIdEntity
{
  @NotNull
  @Size(min = 1)
  private String name;

  public Dummy(String name)
  {
    this.name = name;
  }

  protected Dummy()
  {
  }
}
