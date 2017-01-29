#Running Sample backend services with MS4J


### Geo location service starts on port 8081
```
java -jar  -Dtransports.netty.conf=./netty-transports.yml ./target/org.sample.geo-1.0.0-SNAPSHOT.jar
```

### Bank code service starts on port 8083
```
java -jar  -Dtransports.netty.conf=./netty-transports.yml ./target/org.sample.bankcode-1.0.0-SNAPSHOT.jar
```

### ATM Locator service starts on port 8084
```
java -jar  -Dtransports.netty.conf=./netty-transports.yml ./target/org.sample.atmlocator-1.0.0-SNAPSHOT.jar
```



#Bakend Services
### SOAP  (coordinations supports (1.1/1.1 and 2.2/2.2)

### http://localhost:8281/services/GeoService
```
<soapenv:Envelope xmlns:geo="http://geoservice.sample.org" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
                <soapenv:Header/>
                <soapenv:Body>
                    <p:getZipcode xmlns:p="http://geoservice.sample.org">
                        <!--0 to 1 occurrence-->
                        <xs:x xmlns:xs="http://geoservice.sample.org">1.1</xs:x>
                        <!--0 to 1 occurrence-->
                        <xs:y xmlns:xs="http://geoservice.sample.org">1.1</xs:y>
                    </p:getZipcode>
                </soapenv:Body>
 </soapenv:Envelope>
```



### (Bank code) GET http://localhost:8083/bankcode/{zipcode}
### MS4J
e.g
```
curl -X curl -X GET http://localhost:8083/bankcode/94111

[{"code":"COO1","zip":"94111"},{"code":"COO2","zip":"94111"}]

curl -X curl -X GET http://localhost:8083/bankcode/94105

[{"code":"COO3","zip":"94105"},{"code":"COO4","zip":"94105"}]
```

### (ATM Locator) POST http://localhost:8084/atmlocator/atminfo 
###MS4j
e.g
```
curl -H "Content-Type: application/json" -X POST -d '{"code":"COO1","zip":"94111"}' http://localhost:8084/atmlocator/atminfo
[{"code":"COO1","title":"XYZ ATM A","lat":"37.776414","lng":"-122.413445","zip":"94111","description":"XYZ ATM A"},{"code":"COO1","title":"XYZ ATM B","lat":"37.790795","lng":"-122.451382","zip":"94111","description":"XYZ ATM B"},{"code":"COO1","title":"XYZ ATM C","lat":"37.788353","lng":"-122.431469","zip":"94111","description":"XYZ ATM C"}]
```
## ESB integration (testing purpose only)
```
http://ESB-HOST:ESB-HOST/atmlocator/94111 
or
http://ESB-HOST:ESB-HOST/atmlocator/94111
```
## URL site
```
http://IE-6-HOST:IE-6-PORT/atmlocator-1.0/
```
![Alt text](/images/web-view.png?raw=true "Web Search View")