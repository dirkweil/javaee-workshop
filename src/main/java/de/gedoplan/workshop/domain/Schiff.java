package de.gedoplan.workshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Schiff
{
  @Id
  @GeneratedValue
  private Integer id;
  private String  name;
  private int     anzahlPassagiere;

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getAnzahlPassagiere()
  {
    return this.anzahlPassagiere;
  }

  public void setAnzahlPassagiere(int anzahlPassagiere)
  {
    this.anzahlPassagiere = anzahlPassagiere;
  }

  public Integer getId()
  {
    return this.id;
  }

}
