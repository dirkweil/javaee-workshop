package de.gedoplan.workshop.service;

import de.gedoplan.baselibs.naming.JNDIContextFactory;
import de.gedoplan.baselibs.naming.LookupHelper;
import de.gedoplan.workshop.domain.Talk;

import java.util.List;
import java.util.concurrent.Future;

import javax.naming.Context;

import org.junit.Test;

public class TalkAnnouncementTest
{
  @Test
  public void testGetTalksOfToday() throws Exception
  {
    // Anmeldung am JNDI
    Context jndiCtx = JNDIContextFactory.getInitialContext(null, null, null);

    // Lookup-Namen der Bean bestimmen
    // Die hier genutzte Helfer-Methode baut den Namen serverabhängig zusammen. Für Server, die die Java EE 6 vollständig unterstützen,
    // kann alternativ der standardisierte globale JNDI-Name verwendet werden.
    String lookupName = LookupHelper.getEjbLookupName(TalkAnnouncementRemote.class, null, "javaee-workshop", "TalkAnnouncement");
    // String lookupName = "java:global/javaee-workshop/DailyAnnouncement!de.gedoplan.workshop.service.DailyAnnouncementRemote";
    System.out.println("Lookup-Name: " + lookupName);

    // Lookup der Bean
    TalkAnnouncementRemote remoteObj = (TalkAnnouncementRemote) jndiCtx.lookup(lookupName);

    List<Talk> talksOfToday = remoteObj.getTalksOfToday();
    for (Talk talk : talksOfToday)
    {
      System.out.printf("  %tR: %s, %s\n", talk.getStart(), talk.getSpeakersAsCommaSeparatedList(), talk.getTitle());
    }
  }

  @Test
  public void testDoSomething() throws Exception
  {
    // Anmeldung am JNDI
    Context jndiCtx = JNDIContextFactory.getInitialContext(null, null, null);

    // Lookup-Namen der Bean bestimmen
    // Die hier genutzte Helfer-Methode baut den Namen serverabhängig zusammen. Für Server, die die Java EE 6 vollständig unterstützen,
    // kann alternativ der standardisierte globale JNDI-Name verwendet werden.
    String lookupName = LookupHelper.getEjbLookupName(TalkAnnouncementRemote.class, null, "javaee-workshop", "TalkAnnouncement");
    // String lookupName = "java:global/javaee-workshop/DailyAnnouncement!de.gedoplan.workshop.service.DailyAnnouncementRemote";
    System.out.println("Lookup-Name: " + lookupName);

    // Lookup der Bean
    TalkAnnouncementRemote remoteObj = (TalkAnnouncementRemote) jndiCtx.lookup(lookupName);

    System.out.println("Client start");
    Future<Integer> something = remoteObj.doSomething();
    System.out.println("Client ended");

    Integer value = something.get();
    System.out.println("value: " + value);
  }
}
