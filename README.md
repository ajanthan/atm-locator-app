# Setup
![Alt text](/images/diagram.png?raw=true "Integration View")
## Buld Carbon Applications
- Build common carbon application which is having environmental specific configuration such as endpoints
- Go To 'CommonIntegrationMvnProj'
- Buid common project with following command.
- For on premise : "mvn clean install -Datm.info.host=localhost -Datm.info.port=8084 -Dbankcode.host=localhost -Dbankcode.port=8083 -Dgeo.service.host=localhost -Dgeo.service.port=8085"
- For Integration cloud:  "mvn clean install -Datm.info.host=dushantest-atminfoservice.wso2apps.com -Datm.info.port=80 -Dbankcode.host=dushantest-bankcodeservice.wso2apps.com -Dbankcode.port=80 -Dgeo.service.host=dushantest-geoservice-1-0-0.wso2apps.com -Dgeo.service.port=80"
- Build ATMLocationIntegrationComposite carbon application which is having Integration specific configuration
- Deploy Common and ATMLocationIntegrationComposite Carbon applications to the EI 6.0

## Build Web Application
- Buld https://github.com/dushansachinda/wso2con/tree/master/web/ATMLocator deploy to EI 6.0 under web applications

## Build Microservices
- Go to https://github.com/dushansachinda/wso2con/tree/master/services
- Build 'org.sample.atmlocator', 'org.sample.bankcode', 'org.sample.ws.geo' respectively

## Running Sample backend services with MS4J

### Bank code service [8083]
```
java -jar  -Dtransports.netty.conf=./netty-transports.yml ./target/org.sample.bankcode-1.0.0-SNAPSHOT.jar
```

### ATM Locator service [8084]
```
java -jar  -Dtransports.netty.conf=./netty-transports.yml ./target/org.sample.atmlocator-1.0.0-SNAPSHOT.jar
```

### Geo Locator [8085]
```
java -jar  -Dtransports.netty.conf=./netty-transports.yml ./target/org.sample.ws.geoservice-1.0.0-SNAPSHOT.jar
```


## Testing Bakend services
### (coordinations)

http://localhost:8085/geoservice/zipcode
```
<coordination>
   <lag>1.1</lag>
   <lat>1.1</lat>
</coordination>
```


### (Bank code) 
http://localhost:8083/bankcode/{zipcode}
e.g
```
curl -X curl -X GET http://localhost:8083/bankcode/94111

[{"code":"COO1","zip":"94111"},{"code":"COO2","zip":"94111"}]

curl -X curl -X GET http://localhost:8083/bankcode/94105

[{"code":"COO3","zip":"94105"},{"code":"COO4","zip":"94105"}]
```

### (ATM Locator Info) 
http://localhost:8084/atmlocator/atminfo 
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



# Integration cloud

curl -X GET http://dushantest-bankcodeservice-1-0-0.wso2apps.com:80/bankcode/94111


```
curl -H "Content-Type: application/json" -X POST -d '{"code":"COO1","zip":"94111"}' http://dushantest-atminfoservice-1-0-0.wso2apps.com/atmlocator/atminfo
[{"code":"COO1","title":"XYZ ATM A","lat":"37.776414","lng":"-122.413445","zip":"94111","description":"XYZ ATM A"},{"code":"COO1","title":"XYZ ATM B","lat":"37.790795","lng":"-122.451382","zip":"94111","description":"XYZ ATM B"},{"code":"COO1","title":"XYZ ATM C","lat":"37.788353","lng":"-122.431469","zip":"94111","description":"XYZ ATM C"}]
```

application XML
http://dushantest-geoservice-1-0-0.wso2apps.com/geoservice/zipcode
```
<coordination>
   <lag>1.1</lag>
   <lat>1.1</lat>
</coordination>
```

# Test
http://dushantest-atmlocatorintegratorcapp-1-0-0.wso2apps.com/atmlocator/coordination/1.1/1.1

#Web
http://dushantest-atmlocatorweb-1-0-0.wso2apps.com/
