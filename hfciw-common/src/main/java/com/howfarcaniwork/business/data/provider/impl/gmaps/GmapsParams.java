package com.howfarcaniwork.business.data.provider.impl.gmaps;

public class GmapsParams {
	public enum Output {
		xml, json
	}

	public enum Mode {
		driving, walking, bicycling, transit
	}

	public enum Avoid {
		tolls, highways, ferries
	}

	public enum Units {
		metric, imperial
	}

	public enum GeoCodingStatus {
		OK, ZERO_RESULTS, OVER_QUERY_LIMIT, REQUEST_DENIED, INVALID_REQUEST, UNKNOWN_ERROR
	}
}
