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
        ATMLocation bankCode1_c1 = new ATMLocation("COO1","5 mi · 100 Pine St(877) 242-7372", "37.776414","-122.413445","94111","XYZ ATM A description.....");
        ATMLocation bankCode2_c1 = new ATMLocation("COO1","165 Jackson St (800) 939935", "37.790795","-122.451382","94111","XYZ ATM B description.....");
        ATMLocation bankCode3_c1 = new ATMLocation("COO1","700 Market St (415) 274-3500", "37.788353","-122.431469","94111","XYZ ATM C  description....");
        
        //37.774107, -122.403231
        //37.761555, -122.399969
        //37.753344, -122.396278
        ATMLocation bankCode1_c2 = new ATMLocation("COO2","Mission St(415) 536-3815", "37.774107","37.796193", "-122.441597","XYZ ATM D description....");
        ATMLocation bankCode2_c2 = new ATMLocation("COO2","2500 Mission St (415) 647-8069", "37.803789", "-122.409325","94105","XYZ ATM Edescription....");
        ATMLocation bankCode3_c2= new ATMLocation("COO2","3749 Buchanan St", "37.802433", "-122.455673","94105","XYZ ATM F description....");
       
        
        ATMLocation bankCode1_c3 = new ATMLocation("COO3","Mission blvd (415) 536-3815", "37.778585", "-122.389412","94105","XYZ ATM H description....");
        ATMLocation bankCode2_c3 = new ATMLocation("COO3","600 Temple St (415) 647-8069", "37.766888", "-122.401085","94105","XYZ ATM I description....");
        ATMLocation bankCode3_c3= new ATMLocation("COO3","3749 Dunk St", "37.842570", "-122.4536137","94105","XYZ ATM J description....");
       
        ATMLocation bankCode1_c4 = new ATMLocation("COO4","Trump St(415) 900-3815", "37.756846", "-122.396622","94105","XYZ ATM K description....");
        ATMLocation bankCode2_c4 = new ATMLocation("COO4","2500 Bush St (415) 567-8069", "37.767702", "-122.387009","94105","XYZ ATM L description....");
        ATMLocation bankCode3_c4= new ATMLocation("COO4","3749 Frank St", "37.768788", "-122.390099","94105","XYZ ATM M description....");
       
        
        List<ATMLocation> bankCodeArrayc1 = new ArrayList<>();
        bankCodeArrayc1.add(bankCode1_c1);
        bankCodeArrayc1.add(bankCode2_c1);
        bankCodeArrayc1.add(bankCode3_c1);
        coderepo.put("COO1", bankCodeArrayc1);
        
        List<ATMLocation> bankCodeArrayc2 = new ArrayList<>();
        bankCodeArrayc2.add(bankCode1_c2);
        bankCodeArrayc2.add(bankCode2_c2);
        bankCodeArrayc2.add(bankCode3_c2);
        coderepo.put("COO2", bankCodeArrayc2);
        
        List<ATMLocation> bankCodeArrayc3 = new ArrayList<>();
        bankCodeArrayc3.add(bankCode1_c3);
        bankCodeArrayc3.add(bankCode2_c3);
        bankCodeArrayc3.add(bankCode3_c3);
        coderepo.put("COO3", bankCodeArrayc3);
        
        List<ATMLocation> bankCodeArrayc4 = new ArrayList<>();
        bankCodeArrayc4.add(bankCode1_c4);
        bankCodeArrayc4.add(bankCode2_c4);
        bankCodeArrayc4.add(bankCode3_c4);
        coderepo.put("COO4", bankCodeArrayc4);
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
