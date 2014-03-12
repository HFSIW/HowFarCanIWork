package com.howfarcaniwork.business.data.provider.impl;

import com.howfarcaniwork.business.data.geopoint.GeoPoint;
import com.howfarcaniwork.business.data.provider.GeoDataProvider;
import com.howfarcaniwork.business.data.provider.impl.gmaps.GmapRequest;
import com.howfarcaniwork.business.data.provider.impl.gmaps.GmapsParams.Output;

public class GmapsGeoDataProvider implements GeoDataProvider {

	@Override
	public GeoPoint getUpperLeftBound(GeoPoint p, float distance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeoPoint getPositionFromAddress(String address) {
		GmapRequest request = new GmapRequest();
		return MapsConverter.convert(request.getGeoCoding(false, Output.xml, address, null, false));
	}

	@Override
	public String getAddressFromPosition(GeoPoint p, int precision) {
		GmapRequest request = new GmapRequest();
		return request.getReverseGeoCoding(false, Output.xml, p, null, false);
	}
}
