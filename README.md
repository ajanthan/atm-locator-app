#Running Sample backend services with MS4J

```
java -jar  -Dtransports.netty.conf=./netty-transports.yml ./target/org.sample.bankcode-1.0.0-SNAPSHOT.jar
```

```
java -jar  -Dtransports.netty.conf=./netty-transports.yml ./target/org.sample.geo-1.0.0-SNAPSHOT.jar
```

#Verifying backend services

```
curl -v -X GET http://localhost:8080/op/filename.png > result-opstream.png
```
