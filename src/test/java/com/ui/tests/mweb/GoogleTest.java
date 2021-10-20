package com.ui.tests.mweb;

import com.basetest.AbstractTest;
import com.ui.pages.GoogleHomePage;

import org.testng.annotations.Test;

public class GoogleTest extends AbstractTest {

  @Test
  public void sampleTest() {
    googleHomePage.searchText("NTR");
  }
}
