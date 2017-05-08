package de.gedoplan.workshop.domain;

import de.gedoplan.baselibs.persistence.entity.GeneratedIntegerIdEntity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "JAX_TALK")
@Access(AccessType.FIELD)
@Getter
@Setter
public class Talk extends GeneratedIntegerIdEntity {
  private String title;

  @Column(name = "TALK_TYPE")
  @Enumerated(EnumType.STRING)
  private TalkType type;

  @Transient
  private int dummy;

  public Talk(String title, TalkType type) {
    this.title = title;
    this.type = type;
  }

  protected Talk() {
  }
}
