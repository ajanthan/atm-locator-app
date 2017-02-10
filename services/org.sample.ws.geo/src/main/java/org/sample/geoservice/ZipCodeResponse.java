package org.sample.geoservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ZipCodeResponse {
    private String zip;
    
    public ZipCodeResponse() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ZipCodeResponse(String zip) {
        super();
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}
