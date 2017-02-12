Go To 'CommonIntegrationMvnProj'
then run
mvn clean install -Datm.info.host=localhost -Datm.info.port=8084 -Dbankcode.host=localhost -Dbankcode.port=8083 -Dgeo.service.host=localhost -Dgeo.service.port=8085

For Integration cloud build

mvn clean install -Datm.info.host=dushantest-atminfoservice.wso2apps.com -Datm.info.port=80 -Dbankcode.host=dushantest-bankcodeservice.wso2apps.com -Dbankcode.port=80 -Dgeo.service.host=dushantest-geoservice-1-0-0.wso2apps.com -Dgeo.service.port=80
