package com.howfarcaniwork.business.data.geopoint;

public class PointOutOfBoundsException extends Exception {
	private static final long serialVersionUID = 7541695388653478828L;

	public PointOutOfBoundsException() {
		super();
	}

	public PointOutOfBoundsException(final String message) {
		super(message);
	}
}
