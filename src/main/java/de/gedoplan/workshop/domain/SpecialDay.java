package de.gedoplan.workshop.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
// @Table(name="SPECIAL_DAY")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SpecialDay extends SingleIdEntity<String>
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

  public String getId()
  {
    return this.id;
  }

  public void setId(String id)
  {
    this.id = id;
  }
}
