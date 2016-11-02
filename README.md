Java EE 7 - Workshop
========================

Dies ist das Begleitprojekt zum Workshop "Java EE 7 - Enterprise-Anwendungen ohne Ballast" am 07.11.2016 im Rahmen der W-JAX 2016.

Zum Mitmachen benötigen Sie die folgenden Dinge:

- Einen PC (;-). Das Betriebssystem ist generell zweitrangig. Ich habe allerdings nur Erfahrungen mit Windows und (ein wenig) mit Linux. Zu MacOS kann ich nichts sagen.

- Ein installiertes JDK. Wir benötigen Java 8 (Download für Windows und Linux: http://www.oracle.com/technetwork/java/javase/downloads)

- Einen Git-Client, z. B. Git Bash (Download: http://git-scm.com/downloads)

- Maven 3.x (Download: http://maven.apache.org/download.html)

- Eine IDE ihrer Wahl. Wichtig ist, dass Maven-Projekte importiert werden können und WildFly als Application Server eingebunden werden kann. Ich empfehle dazu das JBoss 
  Developer Studio (http://developers.redhat.com/products/devstudio/download/, es reicht der sog. Stand-alone Installer). Anders als der Name es vermuten lässt, ist es nicht nur 
  für den JBoss Application Server nutzbar. Lassen Sie sich durch den Text auf der Download-Seite nicht verwirren: Die Software ist kostenlos. Sie müssen sich lediglich 
  registrieren.
  
  Das JBDS ist ein Eclipse mit hinzuinstallierten JBoss Tools. Sie können somit auch ihr ggf. bereits installiertes Eclipse aufrüsten. Ich habe in der
  Vergangenheit aber sporadisch das Problem gehabt, dass vermutlich aufgrund inkompatibler Versionen diverser Plugins die Integration nicht vollständig funktional war.
  So konnten bspw. keine Maven-Projekte importiert werden oder die SCM-Anbindung funktionierte nicht mehr etc. etc. Die sichere Wahl ist daher auf jeden Fall das JBDS.
  
  JBDS (wie auch Eclipse) enthält diverse Validatoren, die die Korrektheit von Deskriptoren etc. testen sollen. Leider funktionieren diese Validatoren (zumindest für 
  Maven-Projekte) nicht korrekt. Wenn nach dem Import der Projekte Validierungsfehler (z. B. "JPA Problem") angezeigt werden, sollten Sie die Validatoren deaktiviern 
  (Window -> Preferences -> Validation: Disable All).

- WildFly 10 (Download http://wildfly.org/downloads/). Wir setzen im Workshop diesen Server ein. Generell ist aber jeder Java-EE-7-Server geeignet.

- Recht praktisch zum Verfolgen der Änderungen in der Datenbank ist ein DB-Tool. Grundsätzlich sind viele Tools gut geeignet. Ich setze gerne
  SQL Workbench/J ein (http://www.sql-workbench.net). Im Workshop werden wir die H2-Datenbank nutzen, die auch mit einer eigenen GUI ausgestattet ist.  

Der Branch wjax16 enthält eine Startversion der Enterprise-Anwendung, die im Workshop aufgebaut wird. 

Bitte checken Sie zur Vorbereitung den Branch wjax16 aus, wenn Sie direkt mitmachen wollen. 

Sie können diesen Anfangsstand der Anwendung auch auf Basis eines sog. Maven Archeype erstellen lassen. Lassen Sie dazu in einem Kommandofenster
(Shell bzw. Windows-Cmd) den folgenden Befehl ablaufen:

mvn archetype:generate -DarchetypeCatalog=http://service.gedoplan.de/nexus/content/groups/public/archetype-catalog.xml -DarchetypeGroupId=de.gedoplan -DarchetypeArtifactId=jeewar-maven-archetype -DarchetypeVersion=7.0 -DgroupId=de.gedoplan -DartifactId=javaee-workshop -Dversion=7.0.0-SNAPSHOT -Dpackage=de.gedoplan.workshop -DinteractiveMode=false

Dadurch wird im aktuellen Verzeichnis ein neues Projektverzeichnis namens javaee-workshop erzeugt. Das o. a. GitHub-Verzeichnisses ist genau so
entstanden und wurde lediglich um die Dateien README.md und .gitignore sowie das Verzeichnis additional ergänzt.

Prüfen Sie bitte einmal, ob Sie die Anwendung in der Initialform auf der Kommandozeile bauen können. Öffnen Sie dazu ein Kommando-Fenster und lassen Sie den Befehl mvn laufen (ohne Parameter). Dies sollte ohne Fehlermeldung nach mehr oder weniger kurzer Zeit zu einem "BUILD SUCCESSFUL" führen.

Sollte das nicht klappen, prüfen Sie bitte folgende Dinge:
- Haben Sie ein JDK 8 (nicht nur JRE) installiert? Der Befehl java -version solle ohne Fehler ablaufen.
- Haben Sie Maven in der Version 3 oder höher im Pfad? Der Befehl mvn -version sollte ohne Fehler ablaufen.
- Weist der Wert der Umgebungsvariablen JAVA_HOME auf das Installationsverzeichnis des JDK?
- Weist der Wert der Umgebungsvariablen M2_HOME auf das Installationsverzeichnis von Maven?
Kommen Sie bei hartnäckigen Problemen etwas früher zum Workshop, damit wir uns noch kümmern können.
  
Fragen können während der Veranstaltung natürlich jederzeit gestellt werden und vorher oder nachher gerne an dirk.weil(at)gedoplan.de.

Dirk Weil   