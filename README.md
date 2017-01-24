#Running Sample backend services with MS4J

```
java -jar  -Dtransports.netty.conf=./netty-transports.yml ./target/org.sample.bankcode-1.0.0-SNAPSHOT.jar
```

```
java -jar  -Dtransports.netty.conf=./netty-transports.yml ./target/org.sample.geo-1.0.0-SNAPSHOT.jar
```

#Verifying backend services

```
curl http://localhost:8082/geolocation/zipcode/1/2
{"country":"US","state":"CA","zipcode":"95321"}
```
