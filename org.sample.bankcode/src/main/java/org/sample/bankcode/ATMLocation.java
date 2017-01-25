package org.sample.bankcode;

public class ATMLocation {
    private String code;
    private String title;
    private String lat;
    private String lng;
    private String zip;
    private String description;

    public ATMLocation(String code, String title, String lat, String lng, String zip, String description) {
        super();
        this.code = code;
        this.title = title;
        this.lat = lat;
        this.lng = lng;
        this.zip = zip;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
