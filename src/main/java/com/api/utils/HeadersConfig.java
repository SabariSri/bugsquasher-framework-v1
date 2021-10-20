package com.api.utils;

import java.util.HashMap;
import java.util.Map;

public class HeadersConfig {

	public HeadersConfig() {

	}

	public Map<String, String> defaultHeaders() {
		Map<String, String> defalutHeaders = new HashMap<String, String>();
		defalutHeaders.put("Content-Type", "application/json");
		return defalutHeaders;
	}

	public Map<String, String> headersWithToken() {
		Map<String, String> defalutHeaders = new HashMap<String, String>();
		defalutHeaders.put("Content-Type", "application/json");
		defalutHeaders.put("Acess_Token", "");
		defalutHeaders.put("jwt_token", "");
		defalutHeaders.put("Tenet_user", "");
		return defalutHeaders;
	}
}
