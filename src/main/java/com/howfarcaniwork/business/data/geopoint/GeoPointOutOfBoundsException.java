package com.howfarcaniwork.business.data.geopoint;

public class GeoPointOutOfBoundsException extends Exception {
	private static final long serialVersionUID = 7541695388653478828L;

	public GeoPointOutOfBoundsException() {
		super();
	}

	public GeoPointOutOfBoundsException(final String message) {
		super(message);
	}
}
