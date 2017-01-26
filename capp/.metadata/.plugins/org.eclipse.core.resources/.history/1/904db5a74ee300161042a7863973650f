#Running Sample backend services with MS4J
## Bank code service starts on port 8081
```
java -jar  -Dtransports.netty.conf=./netty-transports.yml ./target/org.sample.bankcode-1.0.0-SNAPSHOT.jar
```

## Geo location service starts on port 8082
```
java -jar  -Dtransports.netty.conf=./netty-transports.yml ./target/org.sample.geo-1.0.0-SNAPSHOT.jar
```

#Sample curl commands 

### http://localhost:8082/geolocation/zipcode/{longitude}/{latitude} 
```
curl http://localhost:8082/geolocation/zipcode/11111/22222 

{"country":"US","state":"CA","zipcode":"95321"}
```

### http://localhost:8081/bankcode/{zipcode}
```
url -X GET http://localhost:8081/bankcode/95321

[{"code":"0001","zip":"95321"},{"code":"0002","zip":"95321"},{"code":"0003","zip":"95321"}]
```