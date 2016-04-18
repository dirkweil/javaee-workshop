package de.gedoplan.workshop.persistence;

public class IdAndName
{
  private String id;
  private String name;

  public IdAndName(String id, String name)
  {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString()
  {
    return "IdAndName [id=" + this.id + ", name=" + this.name + "]";
  }

}
