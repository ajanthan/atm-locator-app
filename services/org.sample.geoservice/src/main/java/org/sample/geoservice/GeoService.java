package org.sample.geoservice;

public class GeoService {
	public int getZipcode(double x, double y) {
		if (x == 1.1 && y == 1.1) {
			return 94111;
		} else if (x == 2.2 && y == 2.2) {
			return 94105;
		}
		return -1;
	}
}