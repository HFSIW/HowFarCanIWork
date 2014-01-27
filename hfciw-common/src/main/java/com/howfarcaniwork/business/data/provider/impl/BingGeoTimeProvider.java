package com.howfarcaniwork.business.data.provider.impl;

import java.util.List;
import java.util.Map;

import com.howfarcaniwork.business.data.TravelMode;
import com.howfarcaniwork.business.data.geopoint.GeoPoint;
import com.howfarcaniwork.business.data.provider.GeoTimeProvider;

public class BingGeoTimeProvider implements GeoTimeProvider {

	@Override
	public long getTravelTime(GeoPoint departure, GeoPoint arrival, TravelMode m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxListLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<GeoPoint, Long> getMatrixTime(List<GeoPoint> points, TravelMode m) {
		// TODO Auto-generated method stub
		return null;
	}

}
