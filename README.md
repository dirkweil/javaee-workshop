Java EE 7 - Workshop
========================

Dies ist das Begleitprojekt zum Workshop Java EE 7.

Zum Mitmachen benötigen Sie die folgenden Dinge:

- Einen PC (;-). Das Betriebssystem ist generell zweitrangig. Ich habe allerdings nur Erfahrungen mit Windows und (ein wenig) mit Linux. Zu MacOS kann ich nichts sagen.

- Ein installiertes JDK. Wir benötigen Java 8 (Download für Windows und Linux: http://www.oracle.com/technetwork/java/javase/downloads/index.html)

- Einen Git-Client, z. B. Git Bash (Download: http://git-scm.com/downloads)

- Maven 3.x (Download: http://maven.apache.org/download.html)

- Eine IDE ihrer Wahl. Wichtig ist, dass Maven-Projekte importiert werden können und WildFly als Application Server eingebunden werden kann. Ich empfehle
  dazu das JBoss Developer Studio - kurz JBDS - (http://www.jboss.org/products/devstudio/download/, es reicht der sog. Stand-alone Installer). Anders als
  der Name es vermuten lässt, ist es nicht nur für den JBoss Application Server nutzbar. Lassen Sie sich durch den Text auf der Download-Seite nicht verwirren:
  Die Software ist kostenlos. Sie müssen sich lediglich registrieren.
  
  Das JBDS ist ein Eclipse mit hinzuinstallierten JBoss Tools. Sie können somit auch ihr ggf. bereits installiertes Eclipse aufrüsten. Ich habe in der
  Vergangenheit aber sporadisch das Problem gehabt, dass vermutlich aufgrund inkompatibler Versionen diverser Plugins die Integration nicht vollständig
  funktional war. So konnten bspw. keine Maven-Projekte importiert werden oder die SCM-Anbindung funktionierte nicht mehr etc. etc. Die sichere Wahl ist 
  daher auf jeden Fall das JBDS.
  
  Achten Sie bei der Installation des JBDS bitte darauf, das zuvor installierte JDK einzubinden, nicht nur das JRE. Sollten Sie sich nicht sicher sein, was
  Sie genau eingebunden haben, so schauen Sie in die Datei devstudio.ini im Verzeichnis studio der JBDS-Installation. Mit der Option -vm wird darin die
  für die Ausführung des JBDS zu nutzende Java-Version konfiguriert - meist in den ersten beiden Zeilen der Datei:
  
  ```
  -vm
  C:/Program Files/Java/jdk1.8.0_101/bin/javaw.exe
  ...
  ```
  
- JBDS (wie auch Eclipse) enthält diverse Validatoren, die die Korrektheit von Deskriptoren etc. testen sollen. Leider funktionieren diese Validatoren
  (zumindest für Maven-Projekte) nicht korrekt. Wenn nach dem Import der Projekte Validierungsfehler (z. B. "JPA Problem") angezeigt werden, sollten Sie
  die Validatoren deaktiviern (Window -> Preferences -> Validation: Disable All).

- WildFly 10 (Download http://wildfly.org/downloads/). Wir setzen im Workshop diesen Server ein. Generell ist aber jeder Java-EE-7-Server geeignet.

- Wir werden im Wokshop Lombok einsetzen, um Schreibarbeit für niedere Dinge (Getter etc.) einzusparen. Für Maven-Projekte und IDEs, die damit direkt arbeiten
  (z. B. Netbeans) ist dazu keine Vorarbeit nötig. Für Eclipse und damit auch für das JBDS muss Lombok als Java Agent eingetragen werden. Kopieren Sie dazu
  bitte die Datei lombok-1.16.12.jar aus dem Projektverzeichnis additional in das Verzeichnis studio Ihrer JBDS-Installation. In der Datei devstudio.ini
  im gleichen Verzeichnis finden Sie am Ende einige Start-Parameter für die JVM, eingeleitet durch -vmargs. Ergänzen Sie dort (nach der Zeile -vmargs) die 
  Zeile -javaagent:lombok-1.16.12.jar. Der gesamte Abschnitt der Ini-Datei sieht dann etwa so aus:
  
  ```
  -vmargs
  -javaagent:lombok-1.16.12.jar
  -Xms512m
  -Xmx1024m
  ...
  ```
  
Der Branch master enthält eine Startversion der Enterprise-Anwendung, die im Workshop aufgebaut wird. Dies geschieht allerdings in einem anderen Branch:
- JAX 2016:   Branch jax16
- WJAX 2016:  Branch wjax16
- JAX 2017:   Branch jax17

Bitte checken Sie zur Vorbereitung den passenden Branch aus, wenn Sie direkt mitmachen wollen.
  
Fragen können während der Veranstaltung natürlich jederzeit gestellt werden und vorher oder nachher gerne an dirk.weil(at)gedoplan.de.

Dirk Weil   
