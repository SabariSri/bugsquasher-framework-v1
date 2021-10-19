package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends AbstractPages {

  @FindBy(xpath = "//input[@title='Search']")
  WebElement SearchFlighHeader;

  public void searchText(String searchKey) {
    clickOn(SearchFlighHeader, "hha");
    setTextAndClickEnter(SearchFlighHeader, searchKey, "heha");
  }
}
