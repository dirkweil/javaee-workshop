package de.gedoplan.workshop.domain;

import de.gedoplan.workshop.persistence.TalkTypeConverter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Talk extends GeneratedIntegerIdEntity
{
  private String       title;

  private List<String> speakers;

  private TalkType     talkType;

  private Date         start;

  private Date         duration;

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


}
