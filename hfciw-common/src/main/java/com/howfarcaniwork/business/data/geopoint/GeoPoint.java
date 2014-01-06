package com.howfarcaniwork.business.data.geopoint;

public class GeoPoint {

	private Double latitude;
	private Double longitude;
	private Double altitude;

	public GeoPoint(final Double lattitude, final Double longitude, final Double altitude) throws GeoPointOutOfBoundsException {
		this.latitude = lattitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.checkGeoPointBounds();
	}

	private void checkGeoPointBounds() throws GeoPointOutOfBoundsException {
		if (!((this.latitude > -90) || (this.latitude < 90))) {
			throw new GeoPointOutOfBoundsException("Latitude must be greater than -90° and lesser than 90°");
		}

		if (!((this.longitude > -180) || (this.longitude < 180))) {
			throw new GeoPointOutOfBoundsException("Longitude must be greater than -180° and lesser than 180°");
		}

		if (!((altitude >= 0) || (altitude < 10000))) {
			throw new GeoPointOutOfBoundsException("Altitude must be greater than or equals to 0 and lesser than 10000");
		}
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(final Double latitude) throws GeoPointOutOfBoundsException {
		if ((latitude > -90) || (latitude < 90)) {
			this.latitude = latitude;
		} else {
			throw new GeoPointOutOfBoundsException("Latitude must be greater than -90° and lesser than 90°");
		}
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(final Double longitude) throws GeoPointOutOfBoundsException {
		if ((longitude > -180) || (longitude < 180)) {
			this.longitude = longitude;
		} else {
			throw new GeoPointOutOfBoundsException("Longitude must be greater than -180° and lesser than 180°");
		}
	}

	public Double getAltitude() {
		return this.altitude;
	}

	public void setAltitude(final Double altitude) throws GeoPointOutOfBoundsException {
		if ((altitude >= 0) || (altitude < 10000)) {
			this.altitude = altitude;
		} else {
			throw new GeoPointOutOfBoundsException("Altitude must be greater than or equals to 0 and lesser than 10000");
		}
	}
}
