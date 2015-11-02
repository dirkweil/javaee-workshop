package de.gedoplan.workshop.domain;

import javax.persistence.Entity;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SpecialDay extends StringIdEntity
{
  private String name;

  @Version
  private long   version;

  public SpecialDay(String id, String name)
  {
    super(id);
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
}
