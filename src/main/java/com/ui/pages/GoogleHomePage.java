package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.basepage.AbstractPage;

public class GoogleHomePage extends AbstractPage {

	@FindBy(xpath = "//textarea[@aria-label='Search']")
	WebElement SearchBox;

	public void searchText(String searchKey) {
		clickOn(SearchBox, "Search Button");
		setTextAndClickEnter(SearchBox, searchKey, "Search Bar");
	}
}
