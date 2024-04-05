package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base implements SeleniumAPI {

	long Timeouts = 30;
	long MaxwaitTime = 10;
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;

	@Override
	public void browseropen(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Timeouts, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, MaxwaitTime);

	}

	@Override
	public void setup(Browser browsername, String url) {
		switch (browsername) {
		case CHROME:
			driver = new ChromeDriver();
			break;

		case FIREFOX:
			driver = new FirefoxDriver();
			break;

		case EDGE:
			driver = new EdgeDriver();
			break;

		default:
			System.err.println("Driver is not defined");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Timeouts, TimeUnit.SECONDS);
		driver.get(url);
	}

	@Override
	public void close() {
		driver.close();
	}

	@Override
	public void quit() {
		driver.quit();
	}

	@Override
	public WebElement element(Locators type, String value) {

		try {
			switch (type) {
			case id:
				return driver.findElementById(value);

			case name:
				return driver.findElementByName(value);

			case classname:
				return driver.findElementByClassName(value);

			case tagname:
				return driver.findElementByTagName(value);

			case xpath:
				return driver.findElementByXPath(value);

			case css:
				return driver.findElementByCssSelector(value);
			default:
				break;
			}
		} catch (NoSuchElementException E) {
			System.err.println("Element is Not Found" + E.getMessage());
			throw new NoSuchElementException("Element not found");
		}

		return null;
	}

	@Override
	public void click(WebElement element) {

		WebElement ELEMENT = wait.withMessage("Element is Not Clickable")
				.until(ExpectedConditions.elementToBeClickable(element));
		ELEMENT.click();
	}

	@Override
	public void type(WebElement element, String Testdata) {
		try {
			WebElement ELEMENT = wait.until(ExpectedConditions.visibilityOf(element));
			ELEMENT.clear();
			ELEMENT.sendKeys(Testdata);
		} catch (NullPointerException e) {
			System.err.println("Element is Null" + e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void typeandEnter(WebElement elemnt, String Testdata, Keys key) {
		WebElement ELEMENT = wait.until(ExpectedConditions.visibilityOf(elemnt));
		ELEMENT.clear();
		ELEMENT.sendKeys(Testdata, key);
	}

	@Override
	public void selectvalue(WebElement element, String value) {

	}

	@Override
	public void selecttext(WebElement element, String text) {

	}

	@Override
	public void selectindex(WebElement element, int position) {

	}

	@Override
	public void appendText(WebElement element) {

	}

	@Override
	public String getTitle() {

		return null;
	}

	@Override
	public String getText() {

		return null;
	}

	@Override
	public boolean isDisplayed() {
		return false;
	}

}
