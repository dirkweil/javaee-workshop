package de.gedoplan.workshop.service;

import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.domain.TalkType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Initialisierungsservice für Demo-Daten.
 *
 * Dieser Service nutzt den Lifecycle-Event nach der Erzeugung des Application Scopes zur Ausführung einer Methode, die einige
 * Demo-Daten in die Datenbank schreibt.
 *
 * Achtung: Es kann hier nicht der "normale", von {@link EntityManagerProducer} erzeugte Entitymanager genutzt werden, da der dazu
 * nötige Request Scope hier noch nicht aktiv ist. Damit sind auch die normalen Repositories nicht verwendbar. Es muss also direkt
 * mit einem eigenen Enitymanager gearbeitet werden!
 *
 * @author dw
 */
@ApplicationScoped
public class InitTrackTalkDemoDataService
{
  @PersistenceContext
  private EntityManager     entityManager;

  private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

  private static Log        log        = LogFactory.getLog(InitTrackTalkDemoDataService.class);

  /**
   * Create test/demo data.
   * Attn: Interceptors may not be called, when method is private!
   *
   * @param event Application scope initialization event
   */
  @Transactional
  void createDemoData(@Observes @Initialized(ApplicationScoped.class) Object event)
  {
    try
    {
      if (this.entityManager.createQuery("select count(t) from Talk t", Long.class).getSingleResult() == 0)
      {
        this.entityManager.persist(new Talk("Workshop zu Lambdas und Streams in Java 8", TalkType.WORKSHOP, dateFormat.parse("2014-05-12 09:00"), 480, "Angelika Langer", "Klaus Kreft"));
        this.entityManager.persist(new Talk("Power Workshop Java EE", TalkType.WORKSHOP, dateFormat.parse("2014-05-12 09:00"), 480, "Dirk Weil"));
        this.entityManager.persist(new Talk("JavaEE (7) Quantum of Code", TalkType.SESSION, dateFormat.parse("2014-05-13 09:45"), 75, "Adam Bean"));
        this.entityManager.persist(new Talk("Feige sein!", TalkType.SESSION, dateFormat.parse("2014-05-13 15:00"), 60, "Dirk Weil"));
        this.entityManager.persist(new Talk("Hypermedia mit JAX-RS 2.0", TalkType.SESSION, dateFormat.parse("2014-05-13 18:00"), 60, "Thilo Frotscher"));
        this.entityManager.persist(new Talk("Eclipse SmartHome", TalkType.SESSION, dateFormat.parse("2014-05-14 16:00"), 60, "Thomas Eichstädt-Engelen"));
        this.entityManager.persist(new Talk("Java SE 8 for Tablets, Pis, and Legos", TalkType.SESSION, dateFormat.parse("2014-05-14 17:15"), 60, "Stephen Chin"));
        this.entityManager.persist(new Talk("Real Steel – der ultimative Roboterfight!", TalkType.SESSION, dateFormat.parse("2014-05-14 20:55"), 120, "Bernhard Löwenstein"));
      }
    }
    catch (Exception e)
    {
      log.warn("Cannot create demo data", e);
    }

  }

}
