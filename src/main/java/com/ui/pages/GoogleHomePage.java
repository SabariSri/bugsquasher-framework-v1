package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.basepage.AbstractPage;

public class GoogleHomePage extends AbstractPage {

	@FindBy(xpath = "//input[@aria-label='Search']")
	WebElement SearchFlighHeader;

	public void searchText(String searchKey) {
		clickOn(SearchFlighHeader, "Search Button");
		setTextAndClickEnter(SearchFlighHeader, searchKey, "Search Bar");
	}
}
