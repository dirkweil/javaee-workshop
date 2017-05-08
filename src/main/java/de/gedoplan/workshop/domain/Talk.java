package de.gedoplan.workshop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Talk {
  private Integer id;
  private String title;
  private TalkType type;

  public Talk(String title, TalkType type) {
    this.title = title;
    this.type = type;
  }

  @Override
  public String toString() {
    return "Talk [id=" + this.id + ", title=" + this.title + ", type=" + this.type + "]";
  }
}
