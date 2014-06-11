package de.gedoplan.workshop.service;

import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

import javax.annotation.security.RolesAllowed;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TalkAnnouncement implements TalkAnnouncementRemote
{
  @Inject
  TalkRepository talkRepository;

  @Override
  @RolesAllowed("ConferenceUser")
  public List<Talk> getTalksOfToday()
  {
    Calendar calendar = Calendar.getInstance();
    calendar.clear(Calendar.HOUR_OF_DAY);
    calendar.clear(Calendar.MINUTE);
    calendar.clear(Calendar.SECOND);
    calendar.clear(Calendar.MILLISECOND);

    Date today = calendar.getTime();

    calendar.add(Calendar.DAY_OF_MONTH, 1);
    Date tomorrow = calendar.getTime();

    return this.talkRepository.findByInterval(today, tomorrow);
  }

  @Schedule(second = "0/10", minute = "*", hour = "*", persistent = false)
  public void announceNextTalk()
  {
    Talk talk = this.talkRepository.findNext();
    if (talk != null)
    {
      System.out.printf("Next talk: %tF %tR: %s, %s\n", talk.getStart(), talk.getStart(), talk.getSpeakersAsCommaSeparatedList(), talk.getTitle());
    }
  }

  @Override
  @Asynchronous
  public Future<Integer> doSomething()
  {
    System.out.println("Start doSomething");

    try
    {
      Thread.sleep(5000);
    }
    catch (InterruptedException e)
    {
    }

    System.out.println("Stop doSomething");

    return new AsyncResult(Integer.valueOf(42));
  }

}
