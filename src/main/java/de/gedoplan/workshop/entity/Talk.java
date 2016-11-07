package de.gedoplan.workshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TALK")
// @NamedQuery(query = "select x from Talk x", name = "talk.all")
public class Talk {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String title;

  @Column(name = "TALK_TYPE")
  private TalkType type;

  public Talk(String title, TalkType type) {
    this.title = title;
    this.type = type;
  }

  @Override
  public String toString() {
    return "Talk [id=" + this.id + ", title=" + this.title + ", type=" + this.type + "]";
  }

  protected Talk() {
  }
}
