Power Workshop Java EE 7
========================

Dies ist das Begleitprojekt zum Workshop am 04.11.2013 im Rahmen der W-JAX 2013.

Zum Mitmachen benötigen Sie die folgenden Dinge:

- Einen PC (;-). Das Betriebssystem ist generell zweitrangig. Ich habe allerdings nur Erfahrungen mit Windows und (ein wenig) mit Linux. Zu MacOS kann ich nichts sagen.

- Ein installiertes JSDK. Wir benötigen Java 7 (Download für Windows und Linux: http://www.oracle.com/technetwork/java/javase/downloads/index.html)

- Einen Git-Client, z. B. Git Bash (Download: http://git-scm.com/downloads)

- Maven 3.0.x (Download: http://maven.apache.org/download.html)

- Eine IDE ihrer Wahl. Wichtig ist, dass Maven-Projekte importiert werden können und WildFly als Application Server eingebunden werden kann. Ich empfehle dazu das
  JBoss Developer Studio (https://devstudio.jboss.com). Anders als der Name es vermuten lässt, ist es nicht nur für den JBoss Application Server nutzbar. Lassen Sie
  sich durch den Text auf der Download-Seite nicht verwirren: Die Software ist kostenlos und unbeschränkt nutzbar. Sie müssen sich lediglich registrieren und haben
  dann 30 Tage Zeit für den Download.
  
  JBDS (wie auch Eclipse) enthält diverse Validatoren, die die Korrektheit von Deskriptoren etc. testen sollen. Leider funktionieren diese Validatoren (zumindest für 
  Maven-Projekte) nicht korrekt. Wenn nach dem Import der Projekte Validierungsfehler (z. B. "JPA Problem") angezeigt werden, sollten Sie die Validatoren deaktiviern 
  (Window -> Preferences -> Validation: Disable All).

- WildFly 8 (Download http://www.wildfly.org/download/, derzeitige Version 8.0.0.Beta1). Wir werden im Workshop diesen Server einsetzen. Generell ist aber jeder 
  Java-EE-7-Server geeignet.
  
  
Bis zum 04.11. - ich freue mich auf Sie!
Dirk Weil   