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

package org.sample.atmlocator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

//var json2 = [
//            {
//                "title": "Stockholm",
//                "lat": 37.776414,
//                "lng": -122.451382,
//                "description": "Stockholm is the capital and the largest city of Sweden and constitutes the most populated urban area in Scandinavia with a population of 2.1 million in the metropolitan area (2010)"
//              },
//              {
//                "title": "Oslo",
//                "lat": 37.790795,
//                "lng": -122.413445,
//                "description": "Oslo is a municipality, and the capital and most populous city of Norway with a metropolitan population of 1,442,318 (as of 2010)."
//              },
//              {
//                "title": "Copenhagen",
//                "lat": 37.788353,
//                "lng": -122.431469,
//                "description": "Copenhagen is the capital of Denmark and its most populous city, with a metropolitan population of 1,931,467 (as of 1 January 2012)."
//              }
//            ]
@Path("/atmlocator")
public class ATMLocatorService {
    Map<String, List<ATMLocation>> coderepo = new HashMap<>();

    public ATMLocatorService() {
        super();
        ATMLocation bankCode1 = new ATMLocation("COO1","5 mi · 100 Pine St(877) 242-7372", "37.776414","-122.413445","94111","XYZ ATM A Open 24 /Long lines and dismissive bankers");
        ATMLocation bankCode2 = new ATMLocation("COO1","165 Jackson St (800) 939935", "37.790795","-122.451382","94111","XYZ ATM B /Very bad customer service. If you want just cash, the service is ok but if you need to talk with a representative be ready for impolines and rudeness.");
        ATMLocation bankCode3 = new ATMLocation("COO1","700 Market St (415) 274-3500", "37.788353","-122.431469","94111","XYZ ATM C /Good service");
        
        //37.774107, -122.403231
        //37.761555, -122.399969
        //37.753344, -122.396278
        ATMLocation bankCode4 = new ATMLocation("COO2","Mission St(415) 536-3815", "37.774107","-122.403231","94105","XYZ ATM G / If this branch is the concept of what a  branch is going to look like, then it is going to be a bleak future. It's a really bad joke to Chase customers.");
        ATMLocation bankCode5 = new ATMLocation("COO2","2500 Mission St (415) 647-8069", "37.761555","-122.39996","94105","XYZ ATM H / Awsome!!!!");
        ATMLocation bankCode6 = new ATMLocation("COO2","3749 Buchanan St", "37.753344","-122.396278","94105","XYZ ATM Y / eware... this branch is not to be trusted!");
       
        
        List<ATMLocation> bankCodeArray = new ArrayList<>();
        bankCodeArray.add(bankCode1);
        bankCodeArray.add(bankCode2);
        bankCodeArray.add(bankCode3);
        coderepo.put("COO1", bankCodeArray);
        
        List<ATMLocation> bankCodeArray2 = new ArrayList<>();
        bankCodeArray2.add(bankCode4);
        bankCodeArray2.add(bankCode5);
        coderepo.put("COO3", bankCodeArray2);
        
        List<ATMLocation> bankCodeArray3 = new ArrayList<>();
        bankCodeArray3.add(bankCode4);
        bankCodeArray3.add(bankCode5);
        bankCodeArray3.add(bankCode6);
        coderepo.put("COO4", bankCodeArray3);
    }

    //curl -H "Content-Type: application/json" -X POST -d '{"code":"COO2","zip":"94105"}' http://localhost:8084/atmlocator/atminfo
    @POST
    @Path("/atminfo")
    @Consumes("application/json")
    @Produces({ "application/json", "text/xml" })
    public Response atminfo(BankCode bankcode ) {
        // TODO: Implementation for HTTP GET request
        System.out.println("retriving ATM information from"+bankcode.getCode() +"|" + bankcode.getZip());
        return Response.ok().entity(coderepo.get(bankcode.getCode())).cookie(new NewCookie("bankcode", bankcode.getCode()))
                .build();

    }
}
