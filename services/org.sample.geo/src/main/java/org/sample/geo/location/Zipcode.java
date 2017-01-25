package org.sample.geo.location;

public class Zipcode {
	String country;
	String state;
	String zipcode;

	public Zipcode(String country, String state, String zipcode) {
		super();
		this.country = country;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
