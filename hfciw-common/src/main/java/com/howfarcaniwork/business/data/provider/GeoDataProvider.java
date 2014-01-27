/**
 * 
 */
package com.howfarcaniwork.business.data.provider;

import com.howfarcaniwork.business.data.geopoint.GeoPoint;

/**
 * This interface is the common abstraction point for all the geographics services as Google maps, Bing Our own service will surely implement this interface too
 * 
 * @author Sylvain
 * 
 */
public interface GeoDataProvider {

	/**
	 * Returns the upper left bounds of the bounding box containing the area within the given distance.
	 * 
	 * @param p
	 *            the departure point
	 * @param distance
	 *            in km
	 * @return a @GeoPoint
	 */
	GeoPoint getUpperLeftBound(GeoPoint p, float distance);

	/**
	 * Get an Lat/Long Coordinate point from an text adress
	 * 
	 * @param address
	 * @return return a geopoint if the address is correct, else null
	 */
	GeoPoint getPositionFromAddress(String address);

	/**
	 * return the closest address
	 * 
	 * @param p
	 * @param precision
	 *            As an Geopoint could not match an exact address for any value Geo Services usualy tolerate an aproximation we will set this as a precision
	 * @return a string or null if no result
	 */
	String getAddressFromPosition(GeoPoint p, int precision);

}
