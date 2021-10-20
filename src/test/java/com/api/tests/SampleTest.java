package com.api.tests;

import com.basetest.AbstractTest;
import com.pages.GoogleHomePage;
import org.testng.annotations.Test;

public class SampleTest extends AbstractTest {

  @Test
  public void sampleTest() {
    googleHomePage.searchText("NTR");
  }
}
