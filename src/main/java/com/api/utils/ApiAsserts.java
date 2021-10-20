package com.api.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.base.AbstractSetup;

import io.restassured.response.Response;

public class ApiAsserts extends AbstractSetup {

	public static void responseCodeValiddation(Response response, int statusCode) {
		try {
			Assert.assertEquals(response.getStatusCode(), statusCode);
			reporter().stepPass("Successfully validdated status code :: " + statusCode);
		} catch (AssertionError e) {
			reporter().stepFailErrorStack(e.fillInStackTrace());
			reporter().stepFail(
					"Expected status code is :: " + statusCode + " - insted getting :: " + response.getStatusCode());
		} catch (Exception e) {
			reporter().stepFailErrorStack(e.fillInStackTrace());
		}
	}

	public static void responseKeyValidationfromArray(Response response, String key) {
		try {
			JSONArray array = new JSONArray(response.getBody().asString());
			for (int i = 0; i < array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				reporter().stepPass("Validated values are  " + obj.get(key));
			}
		} catch (Exception e) {
			reporter().stepFailErrorStack(e.fillInStackTrace());
		}
	}

	public static void responseKeyValidationFromJsonObject(Response response, String key) {
		try {
			JSONObject json = new JSONObject(response.getBody().asString());
			if (json.has(key) && json.get(key) != null) {
				reporter().stepPass("Sucessfully validated value of " + key + " - It is " + json.get(key));
			} else {
				reporter().stepFail("Key is not availble");
			}
		} catch (Exception e) {
			reporter().stepFailErrorStack(e.fillInStackTrace());
		}
	}

	public static void responseTimeValidation(Response response) {
		try {
			long time = response.time();
			reporter().stepInfo("API response time is :: " + time);
		} catch (Exception e) {
			reporter().stepFailErrorStack(e.fillInStackTrace());
		}
	}

}
