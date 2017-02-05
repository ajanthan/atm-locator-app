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

package org.sample.bankcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
@Path("/bankcode")
public class BankCodeService {
    Map<String, List<BankCode>> coderepo = new HashMap<>();

    public BankCodeService() {
        super();
       List<BankCode> bankCodes1 = new ArrayList<>();
       BankCode code1 = new BankCode("COO1","94111");
       BankCode code2 = new BankCode("COO2","94111");
       bankCodes1.add(code1);
       bankCodes1.add(code2);
       
       List<BankCode> bankCodes2 = new ArrayList<>();
       BankCode code3 = new BankCode("COO3","94105");
       BankCode code4 = new BankCode("COO4","94105");
       bankCodes2.add(code3);
       bankCodes2.add(code4);
       
       coderepo.put("94111", bankCodes1);
       coderepo.put("94105", bankCodes2);
       
    }

    @GET
    @Path("/{zipcode}")
    @Produces({ "application/json", "text/xml" })
    public Response bankcodes(@PathParam("zipcode") String zipcode) {
        // TODO: Implementation for HTTP GET request
        System.out.println("retriving bank codes !!! json array" +zipcode +"|"+coderepo.get(zipcode));
        return Response.ok().entity(coderepo.get(zipcode)).cookie(new NewCookie("zipcode", zipcode))
                .build();

    }

}
