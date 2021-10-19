package com.test;

import org.testng.annotations.Test;

public class GoogleTestSecond extends AbstractTest {

  @Test
  public void sampleTest() {
    // googleHomePage.clickOn(GoogleHomePage.SEARCHBAR_TXT_FIELD, "hd");
    // googleHomePage.setTextAndClickEnter(GoogleHomePage.SEARCHBAR_TXT_FIELD, "hello", "hhh");
    googleHomePageSecond.searchText("NTR");
  }
}
