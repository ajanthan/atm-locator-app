/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sample.geoservice;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

/**
 * This is the Microservice resource class. See
 * <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/
 * wso2/msf4j#getting-started</a> for the usage of annotations.
 *
 * @since 1.0.0-SNAPSHOT
 */

@Path("/geoservice")
public class GeoService {
    Map<Coordination, ZipCodeResponse> ziprepo = new HashMap<>();

    public GeoService() {
        super();
        Coordination c1 = new Coordination("1.1", "1.1");
        Coordination c2 = new Coordination("2.2", "2.2");
        ZipCodeResponse z1 = new ZipCodeResponse("94111");
        ZipCodeResponse z2 = new ZipCodeResponse("94105");
        ziprepo.put(c1, z1);
        ziprepo.put(c2, z2);
    }

    // curl -H "Content-Type: application/xml" -X POST -d '<coordination><lag>1.1</lag><lat>1.1</lat></coordination>'
    // http://localhost:8084/geoservice/zipcode
    @POST
    @Path("/zipcode")
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response zipcode(Coordination coordination) {
        // TODO: Implementation for HTTP GET request
        System.out.println("retriving Zip code from Coordination information from" + coordination.getLag() + "|"
                + coordination.getLat());
        ZipCodeResponse codeResponse = ziprepo.get(coordination);
        return Response.ok().entity(codeResponse).cookie(new NewCookie("ZipCodeResponse", "Test")).build();

    }
    
    
    @GET
    @Path("/test")
    @Produces("application/xml")
    public Response get() {
        Coordination coordination = new Coordination("1,1","1.1");
        return Response.ok().entity(coordination).cookie(new NewCookie("coordination", "Test")).build();

    }
}
