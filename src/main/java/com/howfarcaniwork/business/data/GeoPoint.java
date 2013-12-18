package com.howfarcaniwork.business.data;

public class GeoPoint {
	
	long lattitude;
	long longitude;
	
	/**
	 * @param lattitude
	 * @param longitude
	 */
	public GeoPoint(long lattitude, long longitude) {
		super();
		this.lattitude = lattitude;
		this.longitude = longitude;
	}
	
	public long getLattitude() {
		return lattitude;
	}
	public void setLattitude(long lattitude) {
		this.lattitude = lattitude;
	}
	public long getLongitude() {
		return longitude;
	}
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
	
	

}
