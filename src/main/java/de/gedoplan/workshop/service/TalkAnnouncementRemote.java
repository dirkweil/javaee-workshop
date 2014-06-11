package de.gedoplan.workshop.service;

import de.gedoplan.workshop.domain.Talk;

import java.util.List;
import java.util.concurrent.Future;

import javax.ejb.Remote;

@Remote
public interface TalkAnnouncementRemote
{
  public List<Talk> getTalksOfToday();

  public Future<Integer> doSomething();
}
