
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
mvn exec:java -Dexec.mainClass="net.stef.paa.exams.MainJanuary" -Dexec.args="graph" -q
```

```
mvn exec:java -Dexec.mainClass="net.stef.paa.exams.MainFebruary" -Dexec.args="test.txt" -q
```
