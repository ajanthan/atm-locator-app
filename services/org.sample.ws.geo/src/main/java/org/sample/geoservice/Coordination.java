package org.sample.geoservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Coordination {
    private String lag;
    private String lat;

    public Coordination() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Coordination(String lag, String lat) {
        super();
        this.lag = lag;
        this.lat = lat;
    }

    public String getLag() {
        return lag;
    }

    public void setLag(String lag) {
        this.lag = lag;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Coordination) {
            Coordination s = (Coordination) obj;
            return lat.equals(s.lat) && lag.equals(s.lag);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (lat + lag).hashCode();
    }

}
