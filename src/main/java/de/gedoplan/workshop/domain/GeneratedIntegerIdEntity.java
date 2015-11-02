package de.gedoplan.workshop.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlAttribute;

@MappedSuperclass
public class GeneratedIntegerIdEntity extends SingleIdEntity<Integer>
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @XmlAttribute
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
