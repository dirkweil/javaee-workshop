Java EE 7 - Workshop
========================

Dies ist das Begleitprojekt zum Artikel "Java EE 7 - Anwendungsentwicklung ohne Ballast" in der Ausgabe Frühjahr 2016 unserer Fimenzeitschrift GEDOPLAN aktuell.

Zum Ausprobieen benötigen Sie die folgenden Dinge:

- Einen PC (;-). Das Betriebssystem ist generell zweitrangig. Ich habe allerdings nur Erfahrungen mit Windows und (ein wenig) mit Linux. Zu MacOS kann ich nichts sagen.

- Ein installiertes JSDK. Sie benötigen Java 7 oder 8 (Download für Windows und Linux: http://www.oracle.com/technetwork/java/javase/downloads/index.html)

- Maven 3.x (Download: http://maven.apache.org/download.html)

- WildFly 9 (Download http://wildfly.org/downloads/). Generell ist aber jeder Java-EE-7-Server geeignet.

Wenn Sie Git einsetzen, klonen Sie sich das Repository auf Ihren PC. Andernfalls laden Sie sich die Software als ZIP-File herunter und entpacken Sie an einem Ort Ihrer Wahl. Zum Bau der Software reicht der Befehl mvn im Projektverzeichnis (dort, wo die Datei pom.xml liegt). Während des Builds wird ein Internet-Zugang benötigt.

Der Maven-Build erzeugt im Verzeichnis target ein WAR-File, dass im Zielserver deployt werden kann. Für WildFly reicht dazu ein Kopieren der Datei in den Ordner standalone/deployments. Die Anwendung kann dann im Browser mit der Adresse http://localhost:8080/javaee-workshop benutzt werden.

Viel Erfolg - und bei Fragen bitte fragen!

Dirk Weil   
