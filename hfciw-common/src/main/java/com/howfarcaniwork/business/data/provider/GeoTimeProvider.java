package com.howfarcaniwork.business.data.provider;

import java.util.List;
import java.util.Map;

import com.howfarcaniwork.business.data.TravelMode;
import com.howfarcaniwork.business.data.geopoint.GeoPoint;

public interface GeoTimeProvider {

	void setTravelMode(TravelMode m);

	long getTravelTime(GeoPoint departure, GeoPoint arrival);

	int getMaxListLength();

	Map<GeoPoint, Long> getMatrixTime(List<GeoPoint> points);

}
