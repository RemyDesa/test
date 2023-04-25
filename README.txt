****COMPILAZIONE***

----PER COMPILARE LE CLASSI L'ALGORITMO MinHeap NEL PACKAGE MinHeap---
1) posizionarsi in .../Ex4
2) javac -d classes MinHeap/MinHeap.java

---PER COMPILARE LE CLASSI PER GLI UNIT TEST NEL PACKAGE MinHeap---
1) posizionarsi in .../Ex4
2) javac -d classes -cp '.;junit-4.12.jar;hamcrest-core-1.3.jar' MinHeap/*.java (ATTENZIONE: i classpath devono essere separati da ";" come in Windows, non da ":" come in Unix, inoltre, occorre mettere l'elenco dei classpath fra apici semplici!)

----PER COMPILARE LE CLASSI L'ALGORITMO Graph NEL PACKAGE Graph---
1) posizionarsi in .../Ex4
2) javac -d classes Graph/Graph.java

---PER COMPILARE LE CLASSI PER GLI UNIT TEST NEL PACKAGE Graph---
1) posizionarsi in .../Ex4
2) javac -d classes -cp '.;junit-4.12.jar;hamcrest-core-1.3.jar' Graph/*.java (ATTENZIONE: i classpath devono essere separati da ";" come in Windows, non da ":" come in Unix, inoltre, occorre mettere l'elenco dei classpath fra apici semplici!)

----PER COMPILARE LE CLASSI L'ALGORITMO MinHeap NEL PACKAGE Dijkstra---
1) posizionarsi in .../Ex4
2) javac -d classes Dijkstra/Dijkstra.java

----PER COMPILARE IL main---
1) posizionarsi in .../Ex4
2) javac -d classes main.java

***ESECUZIONE***

---PER ESEGUIRE MinHeap/MinHeapTest---
1) posizionarsi in .../Ex4/classes
2) java -cp ".;../junit-4.12.jar;../hamcrest-core-1.3.jar"  MinHeap/MinHeapTestRunner

---PER ESEGUIRE Graph/GraphTest---
1) posizionarsi in .../Ex4/classes
2) java -cp ".;../junit-4.12.jar;../hamcrest-core-1.3.jar"  Graph/GraphTestRunner

---PER ESEGUIRE Main---
1) posizionarsi in .../Ex4/classes
2) java Main torino catania
