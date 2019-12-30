
# Progettazione ed analisi algoritmi esami
In this repository are contained the exams for the month of January and February.


## Prerequisites
+ Maven: https://maven.apache.org/ 
+ JDK8 

## Build:
```
mvn clean install
```

## Execute:
```
mvn exec:java -Dexec.mainClass="net.stef.paa.exams.january2016.Main" -Dexec.args="graph" -q
```

```
mvn exec:java -Dexec.mainClass="net.stef.paa.exams.february2014.Main" -Dexec.args="test.txt" -q
```

```
mvn exec:java -Dexec.mainClass="net.stef.paa.exams.february2016.Main" -Dexec.args="store" -q
```
