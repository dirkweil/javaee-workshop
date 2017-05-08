package de.gedoplan.workshop.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Access(AccessType.FIELD)
@Getter
@Setter
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String lastName;

  private String firstName;

  public Person(String lastName, String firstName) {
    this.lastName = lastName;
    this.firstName = firstName;
  }

  protected Person() {
  }
}
