package com.howfarcaniwork.business.data.provider.impl.gmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.howfarcaniwork.business.data.geopoint.GeoPoint;
import com.howfarcaniwork.business.data.provider.impl.gmaps.GmapsParams.Avoid;
import com.howfarcaniwork.business.data.provider.impl.gmaps.GmapsParams.Mode;
import com.howfarcaniwork.business.data.provider.impl.gmaps.GmapsParams.Output;
import com.howfarcaniwork.business.data.provider.impl.gmaps.GmapsParams.Units;

public class GmapRequest {
	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		GmapRequest http = new GmapRequest();

		System.out.println("Testing 1 - Send Http GET request");
		http.getDirection(Output.xml, "oudrenne", "thionville");

		// System.out.println("\nTesting 2 - Send Http POST request");
		// http.sendPost();

	}

	public String getDirection(Output output, String origin, String destination) throws Exception {
		return getDirection(false, output, origin, destination, null, false, null, null, false);
	}

	public String getDirection(Output output, String origin, String destination, Mode mode) throws Exception {
		return getDirection(false, output, origin, destination, mode, false, null, null, false);
	}

	public String getDirection(Output output, String origin, String destination, Mode mode, Boolean alternative) throws Exception {
		return getDirection(false, output, origin, destination, mode, alternative, null, null, false);
	}

	public String getDirection(Output output, String origin, String destination, Mode mode, Boolean alternative, Avoid avoid) throws Exception {
		return getDirection(false, output, origin, destination, mode, alternative, avoid, null, false);
	}

	public String getDirection(Output output, String origin, String destination, Mode mode, Boolean alternative, Avoid avoid, Units units) throws Exception {
		return getDirection(false, output, origin, destination, mode, alternative, avoid, units, false);
	}

	public String getDirection(Output output, String origin, String destination, Mode mode, Boolean alternative, Avoid avoid, Units units, Boolean sensor)
			throws Exception {
		return getDirection(false, output, origin, destination, mode, alternative, avoid, units, sensor);
	}

	public String getDirection(Boolean ssl, Output output, String origin, String destination, Mode mode) throws Exception {
		return getDirection(false, output, origin, destination, null, false, null, null, false);
	}

	public String getDirection(Boolean ssl, Output output, String origin, String destination, Mode mode, Boolean alternative) throws Exception {
		return getDirection(false, output, origin, destination, null, false, null, null, false);
	}

	public String getDirection(Boolean ssl, Output output, String origin, String destination, Mode mode, Boolean alternative, Avoid avoid) throws Exception {
		return getDirection(false, output, origin, destination, null, false, null, null, false);
	}

	public String getDirection(Boolean ssl, Output output, String origin, String destination, Mode mode, Boolean alternative, Avoid avoid, Units units)
			throws Exception {
		return getDirection(false, output, origin, destination, null, false, null, null, false);
	}

	public String getDirection(Boolean ssl, Output output, String origin, String destination, Mode mode, Boolean alternative, Avoid avoid, Units units,
			Boolean sensor) throws Exception {
		StringBuilder url = new StringBuilder();

		if (ssl) {
			url.append("https");
		} else {
			url.append("http");
		}
		url.append("://maps.googleapis.com/maps/api/directions/");
		url.append(output.toString());
		url.append("?origin=");
		url.append(origin);
		url.append("&destination=");
		url.append(destination);
		url.append("&alternatives=");
		url.append(alternative.toString());
		url.append("&sensor=");
		url.append(sensor.toString());

		if (avoid != null) {
			url.append("&avoid=");
			url.append(avoid.toString());
		}

		if (units != null) {
			url.append("&units=");
			url.append(units.toString());
		}

		if (mode != null) {
			url.append("&mode=");
			url.append(mode.toString());
		}

		return get(url.toString());
	}

	public String getGeoCoding(Boolean ssl, Output output, String adress, String key, Boolean sensor) {
		StringBuilder url = new StringBuilder();

		if (ssl) {
			url.append("https");
		} else {
			url.append("http");
		}
		url.append("://maps.googleapis.com/maps/api/geocode/");
		url.append(output.toString());
		url.append("?address=");
		url.append(adress);
		url.append("&sensor=");
		url.append(sensor.toString());

		if (key != null) {
			url.append("&key=");
			url.append(key);
		}

		return get(url.toString());
	}

	public String getReverseGeoCoding(Boolean ssl, Output output, GeoPoint point, String key, Boolean sensor) {
		StringBuilder url = new StringBuilder();

		if (ssl) {
			url.append("https");
		} else {
			url.append("http");
		}
		url.append("://maps.googleapis.com/maps/api/geocode/");
		url.append(output.toString());
		url.append("?latlng=");
		url.append(point.toString());
		url.append("&sensor=");
		url.append(sensor.toString());

		if (key != null) {
			url.append("&key=");
			url.append(key);
		}

		return get(url.toString());
	}

	private String get(String url) {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url.toString());

		request.addHeader("User-Agent", USER_AGENT);

		HttpResponse response = null;
		try {
			response = client.execute(request);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = null;
		try {
			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuffer result = new StringBuffer();
		String line = "";
		try {
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(result.toString());
		return result.toString();
	}

	public void sendPost() throws Exception {

		String url = "https://selfsolve.apple.com/wcResults.do";

		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);

		// add header
		post.setHeader("User-Agent", USER_AGENT);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
		urlParameters.add(new BasicNameValuePair("cn", ""));
		urlParameters.add(new BasicNameValuePair("locale", ""));
		urlParameters.add(new BasicNameValuePair("caller", ""));
		urlParameters.add(new BasicNameValuePair("num", "12345"));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = client.execute(post);
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + post.getEntity());
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());
	}
}
