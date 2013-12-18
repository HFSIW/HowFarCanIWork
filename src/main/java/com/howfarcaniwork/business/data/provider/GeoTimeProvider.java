package com.howfarcaniwork.business.data.provider;

import java.util.List;
import java.util.Map;

import com.howfarcaniwork.business.data.GeoPoint;
import com.howfarcaniwork.business.data.TravelMode;

public interface GeoTimeProvider {
	
	void setTravelMode(TravelMode m);
	long  getTravelTime(GeoPoint departure, GeoPoint arrival);
	int getMaxListLength();
	Map<GeoPoint,Long> getMatrixTime(List<GeoPoint> points);

}
