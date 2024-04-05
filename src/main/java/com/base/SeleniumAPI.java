package com.base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface SeleniumAPI {

	/**
	 * This is launch the browser
	 * 
	 * @param url
	 */
	void browseropen(String url);

	void setup(Browser browsername, String url);

	void close();

	void quit();

	WebElement element(Locators type, String value);

	void selectvalue(WebElement element, String value);

	void selecttext(WebElement element, String text);

	void selectindex(WebElement element, int position);

	void click(WebElement element);

	void type(WebElement element, String Testdata);

	void typeandEnter(WebElement elemnt, String Testdata, Keys key);

	void appendText(WebElement element);

	String getTitle();

	String getText();

	boolean isDisplayed();

}
