package com.howfarcaniwork.business.data.provider;

import java.util.List;
import java.util.Map;

import com.howfarcaniwork.business.data.TravelMode;
import com.howfarcaniwork.business.data.geopoint.GeoPoint;

public interface GeoTimeProvider {

	long getTravelTime(GeoPoint departure, GeoPoint arrival, TravelMode m);

	int getMaxListLength();

	Map<GeoPoint, Long> getMatrixTime(List<GeoPoint> points);

}
