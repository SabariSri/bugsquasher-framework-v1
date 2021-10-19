package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleHomePageSecond extends AbstractPages {


  @FindBy(xpath = "//input[@title='Search']")
  WebElement SearchFligh;

  public void searchText(String searchKey) {
    clickOn(SearchFligh, "hha");
    setTextAndClickEnter(SearchFligh, searchKey, "heha");
  }
}
