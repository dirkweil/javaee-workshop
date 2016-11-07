package de.gedoplan.workshop.entity;

import de.gedoplan.baselibs.persistence.entity.GeneratedIntegerIdEntity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
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

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(inverseJoinColumns = @JoinColumn(name = "SPEAKER_ID"))
  @Setter(value = AccessLevel.NONE)
  private Set<Person> speakers;

  public Talk(String title, TalkType type) {
    this.title = title;
    this.type = type;
    this.speakers = new HashSet<>();
  }

  protected Talk() {
  }
}
