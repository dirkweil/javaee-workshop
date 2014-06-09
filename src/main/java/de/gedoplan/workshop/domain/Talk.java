package de.gedoplan.workshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Talk implements Serializable
{
  @Id
  @GeneratedValue
  private Integer      id;
  private String       title;

  @ElementCollection(fetch = FetchType.EAGER)
  private List<String> speakers;

  @Enumerated(EnumType.STRING)
  private TalkType     talkType;

  @Temporal(TemporalType.TIMESTAMP)
  private Date         start;

  @Temporal(TemporalType.TIME)
  private Date         duration;

  @ManyToOne
  private SpecialDay   specialDay;

  public Talk(String title, TalkType talkType, Date start, Date duration, String... speakers)
  {
    this.title = title;
    this.talkType = talkType;
    this.start = start;
    this.duration = duration;
    this.speakers = new ArrayList<>();
    for (String speaker : speakers)
    {
      this.speakers.add(speaker);
    }
  }

  protected Talk()
  {
  }

  public Integer getId()
  {
    return this.id;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public List<String> getSpeakers()
  {
    return this.speakers;
  }

  public TalkType getTalkType()
  {
    return this.talkType;
  }

  public void setTalkType(TalkType talkType)
  {
    this.talkType = talkType;
  }

  public Date getStart()
  {
    return this.start;
  }

  public void setStart(Date start)
  {
    this.start = start;
  }

  public Date getDuration()
  {
    return this.duration;
  }

  public void setDuration(Date duration)
  {
    this.duration = duration;
  }

  public String getSpeakersAsCommaSeparatedList()
  {
    StringBuilder sb = new StringBuilder();
    for (String speaker : this.speakers)
    {
      if (sb.length() != 0)
      {
        sb.append(", ");
      }
      sb.append(speaker);
    }

    return sb.toString();
  }

  public void setSpeakersAsCommaSeparatedList(String cs)
  {
    this.speakers.clear();
    for (String speaker : cs.split("\\s*,\\s*"))
    {
      this.speakers.add(speaker);
    }
  }

  public SpecialDay getSpecialDay()
  {
    return this.specialDay;
  }

  public void setSpecialDay(SpecialDay specialDay)
  {
    this.specialDay = specialDay;
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
    Talk other = (Talk) obj;
    if (this.id == null)
    {
      return false;
    }
    else if (!this.id.equals(other.id))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Talk [id=" + this.id + ", title=" + this.title + ", speakers=" + this.speakers + ", talkType=" + this.talkType + ", start=" + this.start + ", duration=" + this.duration + ", specialDay="
        + this.specialDay + "]";
  }

}
