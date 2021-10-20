package com.api.tests;

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
	
	@Test
	public void verifyZippoFailStatus() {
		reporter().startTest("API Test - 002");
		Response response = RestAssured.given().when().get("/IN/99999");
		ApiAsserts.responseCodeValiddation(response, 404);
	}
}
