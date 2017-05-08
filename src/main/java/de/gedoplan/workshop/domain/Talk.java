package de.gedoplan.workshop.domain;

import de.gedoplan.baselibs.persistence.entity.GeneratedIntegerIdEntity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "JAX_TALK")
@Access(AccessType.FIELD)
@Getter
@Setter
public class Talk extends GeneratedIntegerIdEntity {
  @NotNull
  @Size(min = 10, message = "Bitte min. 10 Zeichen")
  @Pattern(regexp = "[A-Z].*")
  private String title;

  @NotNull
  @Column(name = "TALK_TYPE")
  @Enumerated(EnumType.STRING)
  private TalkType type;

  @AssertTrue(message = "Keynotes brauchen lange Titel (min 40 Zeichen)")
  private boolean isValid() {
    return !this.type.equals(TalkType.KEYNOTE) || this.title.length() > 40;
  }

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(joinColumns = @JoinColumn(name = "TALK_ID"), inverseJoinColumns = @JoinColumn(name = "SPEAKER_ID"))
  @Setter(AccessLevel.NONE)
  private Set<Person> speakers;

  @Transient
  private int dummy;

  public Talk(String title, TalkType type) {
    this.title = title;
    this.type = type;
    this.speakers = new HashSet<>();
  }

  protected Talk() {
  }
}
