package de.gedoplan.workshop.entity;

import de.gedoplan.baselibs.persistence.entity.GeneratedIntegerIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TALK")
// @NamedQuery(query = "select x from Talk x", name = "talk.all")
public class Talk extends GeneratedIntegerIdEntity {
  private String title;

  @Column(name = "TALK_TYPE")
  private TalkType type;

  public Talk(String title, TalkType type) {
    this.title = title;
    this.type = type;
  }

  protected Talk() {
  }
}
