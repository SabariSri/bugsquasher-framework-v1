package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePageSecond extends AbstractPage {

	@FindBy(xpath = "//input[@title='Search']")
	WebElement SearchFligh;

	public void searchText(String searchKey) {
		clickOn(SearchFligh, "Search Button");
		setTextAndClickEnter(SearchFligh, searchKey, "Search Bar");
	}
}
