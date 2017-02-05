Go To 'CommonIntegrationMvnProj'
then run
mvn clean install -Datm.info.host=localhost -Datm.info.port=8084 -Dbankcode.host=localhost -Dbankcode.port=8083 -Dgeo.service.host=localhost -Dgeo.service.port=8280



e.g (redered as)
<?xml version="1.0" encoding="UTF-8"?>
<endpoint name="atmInfoEP" xmlns="http://ws.apache.org/ns/synapse">
    <http method="post" uri-template="http://localhost:8084/atmlocator/atminfo"/>
</endpoint>


<?xml version="1.0" encoding="UTF-8"?>
<endpoint name="bankcodeEP" xmlns="http://ws.apache.org/ns/synapse">
    <http method="get" uri-template="http://localhost:8083/bankcode/{uri.var.zipcode}"/>
</endpoint>

<?xml version="1.0" encoding="UTF-8"?>
<endpoint name="GeoEP" xmlns="http://ws.apache.org/ns/synapse">
    <address format="soap11" uri="http://localhost:8280/services/GeoService"/>
</endpoint>
