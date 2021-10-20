package com.api.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.basetest.AbstractTest;

public class ZippoTest {

  @Test
  public void verifyNegativeCase() {
      given().baseUri("").
              when().get("/IN/99999").
              then().
              assertThat().statusCode(404);
  }
}
