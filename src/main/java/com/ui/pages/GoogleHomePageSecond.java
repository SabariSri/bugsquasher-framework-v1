package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.basepage.AbstractPage;

public class GoogleHomePageSecond extends AbstractPage {

	@FindBy(xpath = "//input[@title='Search']")
	WebElement SearchFligh;

	public void searchText(String searchKey) {
		clickOn(SearchFligh, "Search Button");
		setTextAndClickEnter(SearchFligh, searchKey, "Search Bar");
	}
}
