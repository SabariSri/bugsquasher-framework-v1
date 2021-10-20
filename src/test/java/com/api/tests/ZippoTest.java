package com.api.tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.api.utils.ApiAsserts;
import com.basetest.AbstractTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ZippoTest extends AbstractTest {

	@Test
	public void verifyZippoPassStatus() {
		reporter().startTest("API Test - 001");
		Response response = RestAssured.given().when().get("/IN/99999");
		ApiAsserts.responseCodeValiddation(response, 201);
	}

	@Test(dataProvider = "apiTestData", dataProviderClass = com.datadrivers.TestDataProviders.class)
	public void verifyZippoFailStatus(HashMap<String, String> data) {
		reporter().startTest(data.get("TestName"));
		Response response = RestAssured.given().when().get(data.get("EndPoint"));
		ApiAsserts.responseCodeValiddation(response, Integer.parseInt(data.get("StatusCode")));
	}
}
