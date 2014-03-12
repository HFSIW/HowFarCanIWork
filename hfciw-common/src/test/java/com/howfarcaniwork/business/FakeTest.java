package com.howfarcaniwork.business;

import junit.framework.Assert;

import org.junit.Test;

import com.howfarcaniwork.business.data.provider.impl.GmapsGeoDataProvider;

public class FakeTest {

	@Test
	public void fakeTest() {
		// Joke
		Assert.assertTrue(true);
	}

	@Test
	public void GeoDataProviderTest() {
		GmapsGeoDataProvider gmapsProvider = new GmapsGeoDataProvider();
		System.out.println("Test");
		System.out.println(gmapsProvider.getAddressFromPosition(null, 0));
	}
}
