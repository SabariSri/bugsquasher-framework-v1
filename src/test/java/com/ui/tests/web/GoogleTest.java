package com.ui.tests.web;

import com.basetest.AbstractTest;
import com.pages.GoogleHomePage;
import org.testng.annotations.Test;

public class GoogleTest extends AbstractTest {

  @Test
  public void sampleTest() {
    googleHomePage.searchText("NTR");
  }
}
