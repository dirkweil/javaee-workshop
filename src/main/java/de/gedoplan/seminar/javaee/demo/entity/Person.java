package de.gedoplan.seminar.javaee.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person implements Serializable
{
  @Id
  @GeneratedValue
  private Integer id;

  private String  lastName;

  private String  firstName;

  @Temporal(TemporalType.DATE)
  private Date    birthDate;

  private Gender  gender;

  public Person()
  {
  }

  public Person(String lastName)
  {
    this.lastName = lastName;
  }

  public String getLastName()
  {
    return this.lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getFirstName()
  {
    return this.firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public Date getBirthDate()
  {
    return this.birthDate;
  }

  public void setBirthDate(Date birthDate)
  {
    this.birthDate = birthDate;
  }

  public Gender getGender()
  {
    return this.gender;
  }

  public void setGender(Gender gender)
  {
    this.gender = gender;
  }

  public Integer getId()
  {
    return this.id;
  }

  @Override
  public String toString()
  {
    return "Person [id=" + this.id + ", lastName=" + this.lastName + ", firstName=" + this.firstName + ", birthDate=" + this.birthDate + ", gender=" + this.gender + "]";
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (obj == null)
    {
      return false;
    }
    if (getClass() != obj.getClass())
    {
      return false;
    }
    Person other = (Person) obj;
    if (this.id == null)
    {
      if (other.id != null)
      {
        return false;
      }
    }
    else if (!this.id.equals(other.id))
    {
      return false;
    }
    return true;
  }

}
